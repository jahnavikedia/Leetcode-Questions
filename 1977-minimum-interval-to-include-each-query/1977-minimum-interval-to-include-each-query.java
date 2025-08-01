class Solution {
    public int[] minInterval(int[][] intervals, int[] q) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int queries[][] = new int[q.length][2];
        for(int i=0;i<q.length;i++)
        {
            queries[i][0] = q[i];
            queries[i][1] = i;
        }
        Arrays.sort(queries,(a,b)-> a[0]-b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        int i=0; int n = intervals.length;
        int result[] = new int[queries.length];
        for(int query[] : queries)
        {
            while(i<n && intervals[i][0]<=query[0])
            {
                int length = intervals[i][1] - intervals[i][0] + 1;
                minHeap.offer(new int[]{length,intervals[i][1]});
                i++;
            }
            while(!minHeap.isEmpty() && minHeap.peek()[1]<query[0]) minHeap.poll();
            result[query[1]] = !minHeap.isEmpty()?minHeap.peek()[0]:-1;
        }
        return result;
    }
}