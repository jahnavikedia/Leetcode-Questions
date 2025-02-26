class Solution {
    public int longestPalindromeSubseq(String a) {
        String b= new StringBuffer(a).reverse().toString();;
        int m = a.length();
        int t[][]= new int[m+1][m+1];
        for(int i=0;i<m+1;i++)
        {
            for(int j=0;j<m+1;j++)
            {
                if(i==0||j==0)
                t[i][j] = 0;
            }
        }
        for(int i=1;i<m+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1))
                {
                    t[i][j] = 1+t[i-1][j-1];
                }
                else
                {
                    t[i][j] = Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        return t[m][m];
    }
}