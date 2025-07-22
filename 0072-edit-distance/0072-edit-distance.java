class Solution {
    public int minDistance(String a, String b) {
        if(a.equals(b)) return 0;
        int m = a.length();
        int n = b.length();
        int t[][] = new int[m+1][n+1];
        for(int i=0;i<=m;i++)t[i][0] = i;
        for(int j=0;j<=n;j++) t[0][j] = j;
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=n;j++)
            {
                if(a.charAt(i-1)==b.charAt(j-1)) t[i][j] = t[i-1][j-1];
                else
                    t[i][j] = 1+ Math.min(t[i][j-1],Math.min(t[i-1][j],t[i-1][j-1]));
            }
        }
        return t[m][n];
    }
}