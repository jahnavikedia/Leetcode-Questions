class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int t[] = new int[n+1];
        Arrays.fill(t,-1);
        int count = solve(cost,n,0,t);
        int min = Math.min(t[0],t[1]);
        return min;
    }
    public int solve(int cost[], int n, int start, int t[])
    {
        if(start>=n) return 0;
        if(t[start]!=-1) return t[start];
        t[start] = cost[start] + Math.min(solve(cost,n,start+1,t),solve(cost,n,start+2,t));
        return t[start];
    }
}