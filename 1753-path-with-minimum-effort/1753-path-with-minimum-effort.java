class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int effort[][] = new int[m][n];
        for(int row[]: effort) Arrays.fill(row,Integer.MAX_VALUE);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        minHeap.offer(new int[]{0,0,0});
        effort[0][0] = 0;
        int dir[][] = {{0,-1},{-1,0},{0,1},{1,0}};
        while(!minHeap.isEmpty())
        {
            int curr[] = minHeap.poll();
            int r = curr[1]; int c = curr[2]; int currEffort = curr[0];
            if(r==m-1 && c == n-1) return currEffort;
            for(int d[] : dir)
            {
                int nr = r+d[0]; int nc = c+d[1];
                if(nr>=0 && nr<m && nc>=0 && nc<n)
                {
                    int newEffort = Math.max(Math.abs(heights[r][c]-heights[nr][nc]),currEffort);
                    if(newEffort<effort[nr][nc])
                    {
                        effort[nr][nc] = newEffort;
                        minHeap.offer(new int[]{newEffort,nr,nc});
                    }
                }
            }
        }
        return 0;
    }
}