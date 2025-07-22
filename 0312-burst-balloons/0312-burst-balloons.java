class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n+2];
        arr[0] =1;
        arr[n+1]=1;
        for(int i=0;i<n;i++) arr[i+1] = nums[i];
        Integer dp[][] = new Integer[n+2][n+2];
        return burst(arr,1,n,dp);
    }
    public int burst(int arr[],int i, int j, Integer dp[][])
    {
        if(i>j) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for(int k=i;k<=j;k++)
        {
            int coins = arr[i-1]*arr[k]*arr[j+1] + burst(arr,i,k-1,dp)+ burst(arr,k+1,j,dp);
            max = Math.max(coins,max);
        }
        return dp[i][j] = max;
    }
}