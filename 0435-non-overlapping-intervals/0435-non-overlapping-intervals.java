class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> op = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        op.add(intervals[0]);
        int n = intervals.length;
        int j=0;
        for(int i =1;i<n;i++)
        {
            if(op.get(j)[1]>intervals[i][0])
            {
                op.get(j)[1] = Math.min(op.get(j)[1],intervals[i][1]);
            }
            else
            {
                op.add(intervals[i]);
                j++;
            }
        }
        return n-op.size();
    }
}