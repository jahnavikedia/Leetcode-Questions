class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean pacific[][] = new boolean[m][n];
        boolean atlantic[][] = new boolean[m][n];
        for(int i=0;i<m;i++)
        {
            dfs(heights,m,n,i,0,heights[i][0],pacific);
            dfs(heights,m,n,i,n-1,heights[i][n-1],atlantic);
        }
        for(int j=0;j<n;j++)
        {
            dfs(heights,m,n, 0,j,heights[0][j],pacific);
            dfs(heights,m,n,m-1,j,heights[m-1][j],atlantic);
        }
        List<List<Integer>> op = new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(atlantic[i][j] && pacific[i][j])
                {
                    op.add(Arrays.asList(i, j));
                }
            }
        }
        return op;
    }
    private void dfs(int heights[][], int m, int n, int i, int j, int prevHeight, boolean visited[][])
    {
        if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || heights[i][j]<prevHeight) return;
        visited[i][j]= true;
        dfs(heights,m,n, i, j-1,heights[i][j],visited);
        dfs(heights,m,n, i-1, j,heights[i][j],visited);
        dfs(heights,m,n, i, j+1,heights[i][j],visited);
        dfs(heights,m,n, i+1, j,heights[i][j],visited);
        return;
    }
}