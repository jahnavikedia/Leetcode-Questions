class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], max = prices[0], profit =0;
        int n = prices.length;
        for(int i=1;i<n;i++)
        {
            if(prices[i]-min > profit)
            {
                profit = prices[i]-min;
                max = prices[i];
            }
            if(prices[i]<min)
            {
                min = prices[i];
                max = prices[i];
            }
        }
        return profit;
    }
}