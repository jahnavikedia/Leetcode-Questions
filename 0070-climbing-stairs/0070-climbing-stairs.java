class Solution {
    public int climbStairs(int n) {
        int t[] = new int[n+1];
        Arrays.fill(t,-1);
        int count = solve(n,0,t);
        return count;
    }
    public int solve(int n, int start, int t[])
    {
        if(start==n) return 1;
        if(start > n)return 0;
        if(t[start]!=-1) return t[start];
        t[start] = solve(n,start+1,t) + solve(n,start+2,t);
        return t[start];
    }
}