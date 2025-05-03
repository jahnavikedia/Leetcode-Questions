class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int x,y;
        for(int i=0;i<stones.length;i++)
        {
            pq.add(stones[i]);
        }
        while(!pq.isEmpty())
        {
            y = pq.poll();
            if(pq.isEmpty()) return y;
            else x=pq.poll();
            if(x==y) continue;
            else pq.add(y-x);
        }
        return 0;
        
    }
}