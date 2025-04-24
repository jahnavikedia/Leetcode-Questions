class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0],max=prices[0],profit=0;
        int i=0,j=1;

        int n = prices.length;
        while(j<n)
        {
            if(prices[j] - min > profit)
            {
                profit = prices[j] - min;
                max = prices[j];
            }
            if(prices[j]<min)
            {
                min = prices[j];
                max = prices[j];
            }
            j++;
            
        }
        return profit;
    }
}