class Solution {
    public int[] topKFrequent(int[] arr, int k) {
        int op[] = new int[k];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->map.get(b)-map.get(a));
        for(int key : map.keySet())
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