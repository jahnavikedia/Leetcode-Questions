class Solution {
    public int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]=='1')
                {
                    dfs(grid,m,n,i,j);
                    count++;
                }
            }
        }
        return count;
    }
        public void dfs(char grid[][], int m, int n, int i, int j)
        {
            grid[i][j]='0';
            for(int d[] : dir)
            {
                int x = d[0]+i;
                int y = d[1]+j;
                if(x>=0&&x<m&&y>=0&&y<n && grid[x][y]!='0')
                    dfs(grid,m,n,x,y);
            }
        }
}