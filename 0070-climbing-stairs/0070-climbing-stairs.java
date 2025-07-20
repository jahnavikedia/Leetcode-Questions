class Solution {
    public int climbStairs(int n) {
        int t[] = new int[n+1];
        if(n<=2) return n;
        t[1] = 1;
        t[2] = 2;
        for(int i=3;i<=n;i++)
        {
            t[i] = t[i-1]+t[i-2];
        }
        return t[n];
    }
}