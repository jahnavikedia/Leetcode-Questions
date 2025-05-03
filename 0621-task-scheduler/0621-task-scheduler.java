class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> taskFreq = new HashMap<>();
        for(char task:tasks)
        {
            taskFreq.put(task, taskFreq.getOrDefault(task,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());//maxHeap
        pq.addAll(taskFreq.values());
        int totalTime = 0;
        while(!pq.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int cycle = 0;
            for(int i=0;i<=n;i++)
            {
                if(!pq.isEmpty())
                {
                    temp.add(pq.poll());
                    cycle++;
                }
            }
            for(int freq : temp)
            {
                if(freq-1>0)
                {
                    pq.add(freq-1);
                }
            }
            if(pq.isEmpty()) totalTime = totalTime + cycle;
            else totalTime = totalTime + n+1;
        }
        return totalTime;
    }
}