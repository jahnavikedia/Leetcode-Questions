class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if(n==1) {
            result.add(0); return result;
        }
        List<List<Integer>> graph = new ArrayList<>();
        int in[] = new int[n];
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int edge[] : edges)
        {
            graph.get(edge[0]).add(edge[1]);
            in[edge[0]]++;
            graph.get(edge[1]).add(edge[0]);
            in[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(in[i]==1) q.offer(i);
        }
        int rem = n;
        while(rem>2)
        {
            int leaves = q.size();
            rem = rem-leaves;
            for(int i=0;i<leaves;i++)
            {
                int leaf = q.poll();
                for(int nbr : graph.get(leaf))
                {
                    in[nbr]--;
                    if(in[nbr]==1) q.offer(nbr);
                }
            }
        }
        result.addAll(q);
        return result;
    }
}