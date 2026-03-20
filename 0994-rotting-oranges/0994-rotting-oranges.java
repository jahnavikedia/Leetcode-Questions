class Solution {
    public int orangesRotting(int[][] grid) {
        int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++) for(int j=0;j<n;j++)if(grid[i][j]==2)q.offer(new int[]{i,j});
        int time=0;
        while(!q.isEmpty())
        {
            int size = q.size();
            int temp = 0;
            for(int i=0;i<size;i++)
            {
                int p[] = q.poll();
                for(int d[] : dir)
                {
                    int x = p[0]+d[0];
                    int y = p[1]+d[1];
                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1)
                    {
                        temp=1;
                        grid[x][y] = 2;
                        q.offer(new int[]{x,y});
                    }
                }
            }
            time+=temp;
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++) if(grid[i][j]==1) return -1;
        }
        return time;
    }
}