class Solution {
    public int maxProfit(int[] prices) {
        /// two - pointer.
        int n = prices.length;
        int left = 0;
        int right = 1;
        int profit = 0;
        while (right < n) {
            if (prices[left] >= prices[right])   {
                left = right;
                right++;
            }   else {
                int p = prices[right] - prices[left];
                if (p > profit) {
                    profit = p;
                }  
                right++;
            }
        }
        return profit;
    }
}
