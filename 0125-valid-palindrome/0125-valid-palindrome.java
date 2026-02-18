class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        if(s.length()==1) return true;
        int n = s.length();
        int i=0,j=n-1;
        while(i<=j)
        {
            if(!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++; continue;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j)))
            {
                j--;continue;
            }
            else if(s.charAt(i)!=s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}