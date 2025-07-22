class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i] = piles[i];
        for(int i=2;i<=n;i++)
        {
            for(int left = 0;left<=n-i;left++)
            {
                int right = left+i-1;
                int pickLeft = piles[left] - dp[left+1][right];
                int pickRight = piles[right] - dp[left][right-1];
                dp[left][right] = Math.max(pickLeft,pickRight); 
            }
        }
        return dp[0][n-1]>0;
    }
}