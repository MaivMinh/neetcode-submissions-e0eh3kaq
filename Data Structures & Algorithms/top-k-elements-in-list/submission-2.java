class Node implements Comparable<Node> {
    public int value;
    public int freq;

    @Override
    public int compareTo(Node other) {
        if (this.freq != other.freq) {
            return Integer.compare(other.freq, this.freq);  /// max-heap.
        }
        return Integer.compare(other.value, this.value);
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }   else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (Integer key: map.keySet()) {
            Node node = new Node();
            node.value = key;
            node.freq = map.get(key);
            pq.add(node);
        }

        int[] result = new int[k];
        while (k > 0) {
            Node node = pq.poll();
            result[result.length - k] = node.value;            
            k--;
        }
        return result;
    }
}
