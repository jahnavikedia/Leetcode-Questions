class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<>();
        for(String word : words) map.put(word,map.getOrDefault(word,0)+1);
        PriorityQueue<String> minHeap = new PriorityQueue<>(
            (a,b) -> map.get(a).equals(map.get(b)) ?
            b.compareTo(a) : map.get(a)-map.get(b)
        );
        for(String word : map.keySet())
        {
            minHeap.offer(word);
            if(minHeap.size()>k) minHeap.poll();
        }
        List<String> res = new ArrayList<>();
        for(int i=0;i<k;i++)  res.add(minHeap.poll());
        Collections.reverse(res);
        return res;
    }
}