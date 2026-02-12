class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()==1 || s.length()==0) return true;
        s = s.toLowerCase();
        int i=0, j=s.length()-1;
        while(i<=j)
        {
            if(!Character.isLetterOrDigit(s.charAt(i)))
            {
                i++;continue;
            }
            else if(!Character.isLetterOrDigit(s.charAt(j))) 
            {
                j--;continue;
            }
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++; j--;
        }
        return true;
    }
}