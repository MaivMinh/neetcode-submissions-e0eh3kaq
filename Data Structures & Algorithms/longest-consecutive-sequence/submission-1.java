class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)   return 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int max = 1;
        for (int num: nums) {
            int prev = num -1;
            if (!set.contains(prev)) {
                /// start building sequence.
                int count = 1;
                int next = num + 1;
                while (true) {
                    if (set.contains(next)) {
                        count += 1;
                        next++;
                    }   else break;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
