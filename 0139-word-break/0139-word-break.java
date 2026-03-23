class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean dp[] = new boolean[n+1];
        dp[0] = true;
        for(int j=1;j<=n;j++)
        {
            for(int i=0;i<j;i++)
            {
                if(dp[i]==true && set.contains(s.substring(i,j)))
                {
                    dp[j] = true; break;
                }
            }
        }
        return dp[n];

    }
}