class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        if(n==1) return 0;
        boolean visited[] = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        pq.add(new int[]{0,0});
        int totalCost = 0;
        int edgesUsed = 0;
        while(!pq.isEmpty() && edgesUsed<n)
        {
            int[] curr = pq.poll();
            int cost = curr[1];
            int node = curr[0];
            if(visited[node]) continue;
            visited[node] = true;
            edgesUsed++;
            totalCost += cost;
            for(int next=0;next<n;next++)
            {
                if(!visited[next])
                {
                    int nextCost = Math.abs(points[node][0] - points[next][0])+Math.abs(points[node][1]-points[next][1]);
                    pq.add(new int[] {next,nextCost});
                }
            }
        }
        return totalCost;

    }
}