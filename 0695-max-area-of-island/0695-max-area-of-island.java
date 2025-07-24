class Solution {
    public int dir[][] = {{0,-1},{-1,0},{0,1},{1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    max = Math.max(max,dfs(grid,m,n,i,j));
                }
            }
        }
        return max;
    }
    private int dfs(int grid[][],int m, int n, int i, int j)
    {
        grid[i][j] = 0;
        int sum=1;
        for(int d[] : dir)
        {
            int x = i+d[0];
            int y = j+d[1];
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1)
            {
                sum += dfs(grid,m,n,x,y);
            }
        }
        return sum;
    }
}