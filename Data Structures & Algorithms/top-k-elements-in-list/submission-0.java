class Node implements Comparable<Node> {
    public int value;
    public int freq;

    public Node(int value, int freq) {
        this.value = value;
        this.freq = freq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return value == node.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public int compareTo(Node other) {
        // Ưu tiên freq trước (min-heap)
        if (this.freq != other.freq) {
            return (other.freq - this.freq);
        }
        // Nếu freq bằng nhau thì so theo value
        return other.value - this.value;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap();
        PriorityQueue<Node> pq = new PriorityQueue();
        for (int num: nums) {
            if (map.containsKey(num)) {
                Node node = map.get(num);
                node.freq += 1;
                map.put(num, node);
            }       else {
                Node node = new Node(num, 1);
                map.put(num, node);
            }
        }

        for (Integer key: map.keySet()) {
            Node node = map.get(key);
            pq.add(node);
        }

        int[] arr = new int[k];
        while (k > 0) {
            Node node = pq.poll();
            arr[arr.length - k] = node.value;
            k--;
        }
        return arr;
    }
}
