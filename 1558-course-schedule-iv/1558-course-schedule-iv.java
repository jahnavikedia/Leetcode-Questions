class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean dp[][] = new boolean[n][n];
        for(int pre[]:prerequisites)
        {
            dp[pre[0]][pre[1]]=true;
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dp[i][k] && dp[k][j]) dp[i][j] = true;
                }
            }
        }
        List<Boolean> op = new ArrayList<>();
        for(int query[] : queries)
        {
            op.add(dp[query[0]][query[1]]);
        }
        return op;
    }
}