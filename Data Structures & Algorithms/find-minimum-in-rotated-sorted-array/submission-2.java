class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        if (left > right)   return Integer.MAX_VALUE;
        if (left == right)  return nums[left];
        int mid = left + (right - left) / 2;
        if (nums[mid] > nums[mid+1])    {
            return nums[mid+1];
        }
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];
        for (int i = 0; i < leftArr.length; i++) {
            leftArr[i] = nums[left++];
        }
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = nums[left++];
        }

        return Math.min(findMin(leftArr), findMin(rightArr));
    }
}
