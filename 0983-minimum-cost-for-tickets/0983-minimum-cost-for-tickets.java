class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        Integer memo[] = new Integer[n];
        return dfs(days, costs, memo, 0,n); 
    }
    public int dfs(int days[], int costs[], Integer memo[], int i, int n)
    {
        if(i>=n) return 0;
        if(memo[i]!=null) return memo[i];
        int cost1 = costs[0] + dfs(days,costs, memo, i+1, n);
        int j=i;
        while(j<n && days[j]<days[i]+7)j++;
        int cost7 = costs[1]+(dfs(days,costs,memo,j,n));
        j=i;
        while(j<n && days[j]<days[i]+30)j++;
        int cost30 = costs[2]+dfs(days, costs, memo, j, n);
        return memo[i] = Math.min(cost1, Math.min(cost7,cost30));
    }
}