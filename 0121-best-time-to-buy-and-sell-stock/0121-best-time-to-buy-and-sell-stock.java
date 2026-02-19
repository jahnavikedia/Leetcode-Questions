class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        int n = prices.length;
        for(int i=1;i<n;i++)
        {
            min = Math.min(min,prices[i]);
            profit = Math.max(profit,prices[i]-min);
        }
        return profit;
    }
}