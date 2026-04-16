class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)   return 0;
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        int max = Integer.MIN_VALUE;

        for (int num: nums) {
            int count = 1;
            if (!set.contains(num - 1)) {
                /// new starting point.
                num += 1;
                while (true) {
                    if (set.contains(num)) {
                        count += 1;
                    }   else break;
                    num++;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
