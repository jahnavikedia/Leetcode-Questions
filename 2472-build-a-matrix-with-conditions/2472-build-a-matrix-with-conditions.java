class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int op[][] = new int[k][k];
        List<Integer> rowOrder = topoSort(rowConditions,k);
        List<Integer> colOrder = topoSort(colConditions,k);

        if(rowOrder.isEmpty() || colOrder.isEmpty()) return new int[0][0];
        Map<Integer,Integer> rowPos = new HashMap<>();
        Map<Integer,Integer> colPos = new HashMap<>();
        for(int i=0;i<k;i++)rowPos.put(rowOrder.get(i),i);
        for(int i=0;i<k;i++)colPos.put(colOrder.get(i),i);
        for(int i=1;i<=k;i++)
        {
            int r = rowPos.get(i);
            int c = colPos.get(i);
            op[r][c] = i; 
        }
        return op;
    }
    private List<Integer> topoSort(int conditions[][], int k)
    {
        int in[] = new int[k+1];
        Map<Integer,List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=k;i++) graph.put(i,new ArrayList<>());
        for(int condition[] : conditions)
        {
            int u = condition[0];
            int v = condition[1];
            graph.get(u).add(v);
            in[v]++;
        }
        List<Integer> op = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=k;i++) if(in[i]==0) q.offer(i);
        while(!q.isEmpty())
        {
            int curr = q.poll();
            op.add(curr);
            for(int nbr : graph.get(curr))
            {
                in[nbr]--;
                if(in[nbr]==0) q.add(nbr);
            }
        } 
        if(op.size()!=k) return new ArrayList<>();
        return op;
    }
}