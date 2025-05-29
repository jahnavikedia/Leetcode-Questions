class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int op[] = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int key:map.keySet())
        {
            maxHeap.offer(key);
        }
        for(int i=0;i<k;i++)
        {
            op[i] = maxHeap.poll();
        }
        return op;
    }
}