class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
       Map<String,PriorityQueue<String>> map = new HashMap<>();
       int n = tickets.size();
       for(int i=0;i<n;i++)
       {
        map.putIfAbsent(tickets.get(i).get(0), new PriorityQueue<>());
       }
       for(List<String> ticket : tickets)
       {
        map.get(ticket.get(0)).add(ticket.get(1));
       } 
      LinkedList<String> op = new LinkedList<>();
       dfs(op,map,"JFK");
       return op;
    }
    private void dfs(List<String> op, Map<String,PriorityQueue<String>> map, String start)
    {
        PriorityQueue<String> destinations = map.get(start);
        while(destinations!=null && !destinations.isEmpty())
        {
            String next = destinations.poll();
            dfs(op,map,next);
        }
        op.addFirst(start);
    }
}