class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for(int task:tasks)freq[task-'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a);
        for(int f: freq) if(f>0)maxHeap.offer(f);
        int time=0;
        while(!maxHeap.isEmpty())
        {
            List<Integer> temp = new ArrayList<>();
            int slots=n+1;
            while(slots>0 && !maxHeap.isEmpty())
            {
                int maxFreq = maxHeap.poll();
                temp.add(maxFreq-1);
                slots--;
                time++;
            }
            for(int t: temp)if(t>0)maxHeap.offer(t);
            if(!maxHeap.isEmpty())time+=slots;
        }
        return time;
    }
}