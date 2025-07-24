class Solution {
    public int[] findOrder(int n, int[][] preReq) {
        ArrayList<Integer> op = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++) map.put(i,new ArrayList<>());
        int in[] = new int[n];
        for(int[] pre : preReq)
        {
            map.get(pre[1]).add(pre[0]);
            in[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) if(in[i]==0) q.offer(i);
        while(!q.isEmpty())
        {
            int f=q.poll();
            op.add(f);
            for(int nbr: map.get(f))
            {
                in[nbr]--;
                if(in[nbr]==0) q.offer(nbr);
            }
        }
        if(op.size()!=n) return new int[0];
        int result[] = new int[n];
        for(int i=0;i<n;i++)result[i] = op.get(i);
        return result;
    }
}