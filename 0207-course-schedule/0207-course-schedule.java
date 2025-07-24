class Solution {
    public boolean canFinish(int n, int[][] prereq) {
        Map<Integer,List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < n; i++) adj.put(i, new ArrayList<>());
        int in[] = new int[n];
        for(int[] pre : prereq)
        {
            adj.get(pre[1]).add(pre[0]);
            in[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(in[i]==0)q.offer(i);
        }
        int count=0;
        while(!q.isEmpty())
        {
            int f = q.poll();
            count++;
            for(int nbr : adj.get(f))
            {
                in[nbr]--;
                if(in[nbr] ==0) q.offer(nbr);
            }
        }
        //for(int i=0;i<n;i++)if(in[i]!=0)return false;return true;
        return count==n;
    }
}