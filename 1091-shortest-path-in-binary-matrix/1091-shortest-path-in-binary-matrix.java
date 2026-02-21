class Solution {
    int dir[][] = {{1,0},{0,1},{-1,0},{0,-1},{-1,1},{-1,-1},{1,-1},{1,1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        grid[0][0] = 1;
        while(!q.isEmpty())
        {
            int curr[] = q.poll();
            int r = curr[0], c = curr[1], dist = curr[2];
            if(r==m-1 && c == n-1) return dist;
            for(int d[]:dir)
            {
                int nr = d[0]+r;
                int nc = d[1] + c;
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==0) 
                {
                    q.offer(new int[]{nr,nc,dist+1});
                    grid[nr][nc]=1;
                }
            }
        }
        return -1;
    }
}