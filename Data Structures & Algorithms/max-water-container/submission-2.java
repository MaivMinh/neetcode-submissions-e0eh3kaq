class Solution {
    private int calAmountWater(int l, int r, int[] arr) {
        return (r - l) * Math.min(arr[l], arr[r]);
    }

    public int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int max = 0;
        while (l < r) {
            int num = calAmountWater(l, r, heights);
            max = Math.max(max, num);
            if (heights[l] < heights[r]) {
                l++;
            }   else r--;
        }
        return max;
    }
}
