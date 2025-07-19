class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean t[] = new boolean[n+1];
        Set<String> set = new HashSet<>(wordDict);
        t[0] = true;
        int maxLen = 0;
        for(String word : wordDict) maxLen = Math.max(maxLen,word.length());
        for(int i=1;i<=n;i++)
        {
            for(int j= i-1;j>=Math.max(0,i-maxLen);j--)
            {
                if(t[j] && set.contains(s.substring(j,i)))
                {
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n];
    }
}