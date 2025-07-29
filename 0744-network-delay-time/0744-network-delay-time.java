class Pair
{
    int node;
    int dist;
    Pair(int node, int dist)
    {
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer,List<Pair>> map = new HashMap<>();
        for(int i=1;i<=n;i++)
        {
            map.put(i, new ArrayList<>());
        }
        for(int[] time : times)
        {
            int src = time[0];
            int dest = time[1];
            int w = time[2];
            map.get(src).add(new Pair(dest,w));
        }
        int distance[] = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.offer(new Pair(k,0));
        Set<Integer> visited = new HashSet<>();
        while(!pq.isEmpty())
        {
            int curr = pq.poll().node;
            if(visited.contains(curr)) continue;
            visited.add(curr);
            for(Pair nbr : map.get(curr))
            {
                int nbr_node = nbr.node;
                int nbr_dist = nbr.dist;
                if(distance[curr] + nbr.dist < distance[nbr_node])
                {
                    distance[nbr_node] = distance[curr]+nbr.dist;
                    pq.offer(new Pair(nbr_node,distance[nbr_node]));
                }
            }
        }
        int max = -1;
        for(int i = 1;i<=n;i++) 
        {
            if(distance[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max, distance[i]);
        }
        return max;
    }
}