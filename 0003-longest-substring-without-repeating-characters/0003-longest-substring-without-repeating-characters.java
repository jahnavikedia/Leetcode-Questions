class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i=0,j=0,maxLen = 0;
        int n = s.length();
        while(j<n)
        {
            char ch = s.charAt(j);
            while(set.contains(ch))
            {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(ch);
            maxLen=Math.max(maxLen,j-i+1);
            j++;
        }
        return maxLen;
    }
}