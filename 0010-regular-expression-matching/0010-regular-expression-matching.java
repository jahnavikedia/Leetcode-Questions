class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        Boolean dp[][] = new Boolean[m+1][n+1];
        return helper(0,0,s,p,m,n,dp);
    }
    private boolean helper(int i, int j, String s, String p, int m, int n,Boolean dp[][])
    {
        if(dp[i][j]!=null) return dp[i][j];
        if(j==n) return dp[i][j] = i==m;
        boolean currentMatch = (i<m && (s.charAt(i)==p.charAt(j) 
        || p.charAt(j)=='.' ) );
        if(j+1<n && p.charAt(j+1) == '*')
        {
            dp[i][j] = helper(i,j+2,s,p,m,n,dp) || (currentMatch && helper(i+1,j,s,p,m,n,dp));
        }
        else
        {
            dp[i][j] = currentMatch && helper(i+1,j+1,s,p,m,n,dp);
        }
        return dp[i][j];
    }
}