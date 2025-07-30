class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];
        int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}}; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.offer(new int[] {grid[0][0],0,0});
        visited[0][0] = true;
        while(!pq.isEmpty())
        {
            int curr[] = pq.poll();
            int time = curr[0];int r = curr[1]; int c = curr[2];
            if(r==n-1 && c==n-1) return time;
            for(int d[] : dirs)
            {
                int nr = d[0]+r;
                int nc = d[1]+c;
                if(nr>=0 && nr<n && nc >=0 && nc<n && !visited[nr][nc])
                {
                    visited[nr][nc] = true;
                    int nt = Math.max(time,grid[nr][nc]);
                    pq.offer(new int[]{nt,nr,nc});

                }
            }
        }
        return -1;
    }
}