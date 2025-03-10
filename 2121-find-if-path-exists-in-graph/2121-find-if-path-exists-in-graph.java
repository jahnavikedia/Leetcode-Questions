class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[] = new boolean[n];
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            adj.put(i, new ArrayList<>());
        }
        for(int edge[] : edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return dfs(n,adj,source,destination,visited);
    }
    public boolean dfs(int n, Map<Integer,List<Integer>> adj, int source, int destination, boolean visited[])
    {
        if(source==destination)
        {
            return true;
        }
        visited[source] = true;
        for(int nbr : adj.get(source))
        {
            if(!visited[nbr])
            {
                visited[nbr] = true;
                if(dfs(n,adj,nbr,destination,visited))
                {
                    return true;
                }
            }
        }
        return false;
    }
}