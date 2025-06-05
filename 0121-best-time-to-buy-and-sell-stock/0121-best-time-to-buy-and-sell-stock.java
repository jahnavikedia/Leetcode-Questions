class Solution {
    public int maxProfit(int[] prices) {
        int max = prices[0], min = prices[0], profit = 0;
        for(int j=1;j<prices.length;j++)
        {
            if(prices[j]-min > profit)
            {
                profit = prices[j]-min;
                max = prices[j];
            }
            if(prices[j]<min)
            {
                min = prices[j];
                max = prices[j];
            }
        }
        return profit;
    }
}