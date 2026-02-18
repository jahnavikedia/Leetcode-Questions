class Solution {
    public int dir[][] = {{0,1},{-1,0},{0,-1},{1,0}};
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int i=0;i<m;i++)
        {
             for(int j=0;j<n;j++)
             {
                if(grid[i][j]!=0){
                    long sum = dfs(grid,m,n,i,j);
                    if(sum%k==0)count++;
                }
             }
        }
        return count;
    }
    public long dfs(int grid[][], int m, int n, int i, int j)
    {
        if(grid[i][j]==0) return 0;
        long val = grid[i][j];
        grid[i][j] = 0;
        for(int d[] : dir)
        {
            int x = d[0]+i;
            int y = d[1]+j;
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]!=0)
                val+=dfs(grid,m,n,x,y);
        }
        return val;
    }
}