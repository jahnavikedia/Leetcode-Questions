class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int t[] = new int[n+2];
        t[n] = 0;
        t[n+1] = 0;
        for(int i=n-1;i>=0;i--)
        {
            t[i] = cost[i] + Math.min(t[i+1],t[i+2]);
        }
        int min = Math.min(t[0],t[1]);
        return min;
    }
    
}