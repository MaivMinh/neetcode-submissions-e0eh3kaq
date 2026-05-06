class Solution {
    public int min = Integer.MAX_VALUE;

    public int findMin(int[] nums) {
        int l = 0;
        int n = nums.length;
        int r = n - 1;
        min = Math.min(nums[l], min);
        System.out.println(min);
        if (l == r) return min;

        int mid = l + (r - l) / 2;
        if (nums[mid] >= nums[l]) {
            return findMin(Arrays.copyOfRange(nums, mid + 1, n));
        }
        return findMin(Arrays.copyOfRange(nums, l, mid + 1));
    }
}
