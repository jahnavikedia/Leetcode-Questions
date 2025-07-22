class Solution {
    public int numDistinct(String a, String b) {
        int m = a.length();
        int n = b.length();
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=m;i++)
        {
            for(int j=n;j>=1;j--)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                    dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[n];
    }
}