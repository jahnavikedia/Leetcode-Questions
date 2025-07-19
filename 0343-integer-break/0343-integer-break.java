class Solution {
    public int integerBreak(int n) {
        int t[] = new int[n+1];
        t[1] = 1;
        for(int i=2;i<=n;i++)
        {
            for(int j=1;j<i;j++)
            {
                t[i] = Math.max(t[i],Math.max(j*(i-j),j*t[i-j]));
            }
        }
        return t[n];
    }
}