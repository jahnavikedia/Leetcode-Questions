class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        if(n==1) return 1;
        int count=0;
        for(int i=0;i<n;i++)
        {
            int odd = expand(s,i,i);
            int even = expand(s,i,i+1);
            count+=odd+even;
        }
        return count;
    }

    public int expand(String s, int left, int right)
    {
        int count =0;
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
        {
            left--;right++;count++;
        }
        return count;
    }
}