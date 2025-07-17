class Solution {
    public String longestPalindrome(String s) {
        String lps = "";
        for(int i=0;i<s.length();i++)
        {
            String odd = expand(s,i,i);
            String even = expand(s,i,i+1);
            if(odd.length()>lps.length()) lps = odd;
            if(even.length() > lps.length()) lps = even;
        }
        return lps;
    }
    private String expand(String s, int left, int right)
    {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right))
        {
            left--; right++;
        }
        return s.substring(left+1,right);
    }
}