class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0], max = prices[0];
        int profit = 0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]-min > profit)
            {
                profit = prices[i] - min;
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