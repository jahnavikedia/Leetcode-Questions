class Solution {
    public int[] findOrder(int n, int[][] preReq) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        int in[] = new int[n];
        for(int i=0;i<n;i++)adj.put(i,new ArrayList<>());
        for(int pre[] : preReq){
            adj.get(pre[1]).add(pre[0]);
            in[pre[0]]++;
        } 
        Queue<Integer> q = new LinkedList<>();
        int count=0;
        for(int i=0;i<n;i++)if(in[i]==0) q.offer(i);
        List<Integer> op = new ArrayList<>();
        while(!q.isEmpty())
        {
            count++;
            int f = q.poll();
            op.add(f);
            for(int nbr: adj.get(f))
            {
                in[nbr]--;
                if(in[nbr]==0) q.offer(nbr);
            }
        }
        if(count!=n) return new int[0];
        int res[] = new int[op.size()];
        for(int i=0;i<op.size();i++) res[i] = op.get(i);
        return res;
    }
}