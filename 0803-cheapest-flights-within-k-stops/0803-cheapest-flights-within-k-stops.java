class Pair
{
    int node;
    int price;
    int stops;
    Pair(int node, int price, int stops){
        this.node= node;
        this.price = price;
        this.stops = stops;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i,new ArrayList<>());
        for(int flight[] : flights)
        {
            map.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.price - b.price);
        pq.offer(new Pair(src,0,0));
        int best[][] = new int[n][k+2];
        for(int arr[] : best) Arrays.fill(arr,Integer.MAX_VALUE);
        best[src][0] = 0;
        while(!pq.isEmpty())
        {
            Pair curr = pq.poll();
            if(curr.node == dst) return curr.price;
            if(curr.stops>k) continue;
            for(int nbr[] : map.get(curr.node))
            {
                int nbrNode = nbr[0];
                int nbrPrice = curr.price + nbr[1];
                int nbrStops = curr.stops+1;
                if(nbrPrice<best[nbrNode][nbrStops])
                {
                    best[nbrNode][nbrStops]=nbrPrice;
                    pq.offer(new Pair(nbrNode,nbrPrice, nbrStops));
                }
            }
        }
        return -1;
    }
}