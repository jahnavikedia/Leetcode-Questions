class Solution {
    public int numSquares(int n) {
        int t[] = new int[n+1];
        Arrays.fill(t,Integer.MAX_VALUE);
        t[0] = 0;
        for(int i=1;i<=n;i++)
        {
            for(int s=1;s*s<=i;s++)
            {
                int square = s*s;
                t[i] = Math.min(t[i],1+t[i-square]);
            }
        }
        return t[n];
    }
}