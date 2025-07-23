class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer dp[][] = new Integer[n][n];
        return solve(piles,0,n-1,dp)>0;
    }
    public int solve(int piles[], int left, int right, Integer dp[][])
    {
        if(left>right) return 0;
        if(dp[left][right] != null) return dp[left][right];
        int pickLeft = piles[left]-solve(piles,left+1,right,dp);
        int pickRight = piles[right]-solve(piles,left,right-1,dp);
        return dp[left][right] = Math.max(pickLeft,pickRight);
    }
}