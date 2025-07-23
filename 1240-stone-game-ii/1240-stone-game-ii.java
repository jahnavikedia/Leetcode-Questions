class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int suffixSum[] = new int[n+1];
        for(int i=n-1;i>=0;i--)
            suffixSum[i] = piles[i] + suffixSum[i+1];
        Integer dp[][] = new Integer[n][n+1];
        return helper(0,1,piles,suffixSum,dp);
    }
    int helper(int i, int m, int piles[], int suffixSum[], Integer dp[][])
    {
        int n = piles.length;
        if(i>=n) return 0;
        if(2*m > n-i) return suffixSum[i];
        if(dp[i][m] != null) return dp[i][m];
        int min = Integer.MAX_VALUE;
        for(int x=1;x<=2*m;x++)
        {
            min = Math.min(min, helper(i+x, Math.max(m,x),piles,suffixSum,dp));
        }
        return dp[i][m] = suffixSum[i] - min;
    }
}