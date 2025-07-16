class Solution {
    public int climbStairs(int n) {
        int t[] = new int[n+2];
        t[n] = 1;
        t[n+1] = 0;
        for(int i=n-1;i>=0;i--)
        {
            t[i] = t[i+1]+t[i+2];
        }
        return t[0];
    }
}