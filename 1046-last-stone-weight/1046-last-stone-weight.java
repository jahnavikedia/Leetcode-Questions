class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = stones.length;
        for(int stone: stones) pq.offer(stone);
        while(!pq.isEmpty())
        {
            int first = pq.poll();
            if(pq.isEmpty()) return first; 
            int second = pq.poll();
            if(first!=second)
            {
                pq.offer(first-second);
            } 
        }
        if(pq.isEmpty()) return 0; return pq.peek();
    }
}