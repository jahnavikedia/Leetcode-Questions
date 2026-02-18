class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Queue<Integer> minHeap= new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        int op[] = new int[k];
        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key: map.keySet())
        {
            minHeap.offer(key);
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        int i=0;
        while(!minHeap.isEmpty())
        {
            op[i] = minHeap.poll();
            i++;
        }
        return op;
    }
}