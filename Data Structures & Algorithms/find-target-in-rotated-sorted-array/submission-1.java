class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        while (l <= r)  {
            if (l == r) return (target == nums[l]) ? l: -1;
            int mid = l + (r - l) / 2;
            if (nums[mid] == target)    return mid;
            if (nums[l] <= nums[mid]) {
                /// left ascending.
                if (nums[l] <= target && target < nums[mid])    {
                    r = mid - 1;
                }   else l = mid + 1;
            }   else {
                /// right ascending.
                if (nums[mid] <= target && target <= nums[r]) {
                    l = mid + 1;
                }   else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}