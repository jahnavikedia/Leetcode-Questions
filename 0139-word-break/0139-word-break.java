class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        int maxLen =-1;
        for(String word : wordDict) maxLen = Math.max(maxLen,word.length());
        boolean t[] = new boolean[n+1];
        t[0] = true;
        for(int i=1;i<=n;i++)
        {
            for(int j=i-1;j>=Math.max(0,i-maxLen);j--)
            {
                if(t[j]&& set.contains(s.substring(j,i)))
                {
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n];
    }
}