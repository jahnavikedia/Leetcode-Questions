class Solution {
    public int dirs[][] = {{0,1},{-1,0},{0,-1},{1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int max=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==1)
                {
                    max = Math.max(max, dfs(grid,i,j,m,n));
                }
            }
        }
        return max;
    }

    public int dfs(int grid[][], int i, int j, int m, int n)
    {
        grid[i][j] = 0;
        int sum = 1;
        for(int dir[]: dirs)
        {
            int x = dir[0]+i;
            int y = dir[1]+j;
            if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1) sum+=dfs(grid,x,y,m,n);
        }
        return sum;
    }
}