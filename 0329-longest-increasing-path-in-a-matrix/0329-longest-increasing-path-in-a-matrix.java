class Solution {
public int dir[][] = {{1,0},{0,-1},{0,1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        int m=matrix.length;
        int n= matrix[0].length;
        int max=0;
        int t[][] = new int[m][n];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                max = Math.max(max,dfs(matrix,m,n,i,j,t));
            }
        }
        return max;
    }
    public int dfs(int grid[][],int m,int n, int i,int j,int t[][])
    {
        if(t[i][j]>0) return t[i][j];
        int max=0;
        for(int d[] : dir)
        {
            int x = i+d[0];
            int y = j+d[1];
            if(isSafe(x,y,grid,m,n) && grid[x][y]> grid[i][j]) 
            {
                max = Math.max(max,dfs(grid,m,n,x,y,t));
            }
        }
        t[i][j] = max+1;
        return max+1;
    }
    public boolean isSafe(int i,int j, int grid[][], int m, int n)
    {
        if(i>=0 && i<m && j>=0 && j<n) return true;
        return false;
    }
}