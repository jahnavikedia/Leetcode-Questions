class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n=grid[0].length;
        if(grid[0][0] == 1 || grid[m-1][n-1]==1) return 0;
        int t[][] = new int[m][n];
        t[0][0] = 1;
        for(int i=1;i<m;i++)if(grid[i][0]!=1 && t[i-1][0]==1) t[i][0] = 1;
        for(int j=1;j<n;j++)if(grid[0][j]!=1 && t[0][j-1]==1) t[0][j] = 1;
        for(int i=1;i<m;i++)
        {
            for(int j=1;j<n;j++)
            {
                if(grid[i][j]!=1) t[i][j] = t[i-1][j] + t[i][j-1];
            }
        }
        return t[m-1][n-1];
    }
}