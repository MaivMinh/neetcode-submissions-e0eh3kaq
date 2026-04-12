class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)   return 0;
        int[] count = new int[nums.length];
        count[0] = 1;
        int max = 1;
        Arrays.sort(nums);  /// take O(NlogN) time complexity.
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1] + 1) {
                count[i] = count[i-1] + 1;
                max = Math.max(count[i], max);
            }   else if (nums[i] == nums[i-1]) {
                count[i] = count[i-1];
            }   else {  /// nums[i] >> nums[i-1].
                count[i] = 1;
            }
        }

        return max;
    }
}
