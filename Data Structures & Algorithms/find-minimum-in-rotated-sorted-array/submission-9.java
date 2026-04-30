class Solution {
    public int findMin(int[] nums) {
        if (nums.length > 0) {
            int result = nums[0];
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            int mid = left + (right - left) / 2;
            if (left > right)
                return Integer.MAX_VALUE;
            System.out.println(left + " " + right + " " + mid);
            if (nums[mid] >= nums[left]) {
                /// search right.
                int[] arr = Arrays.copyOfRange(nums, mid + 1, right + 1);
                result = Math.min(result, findMin(arr));
                result = Math.min(result, nums[mid]);
            } else {
                /// search left.
                int[] arr = Arrays.copyOfRange(nums, left, mid);
                result = Math.min(result, findMin(arr));
                result = Math.min(result, nums[mid]);
            }
            return result;
        }
        return Integer.MAX_VALUE;
    }
}
