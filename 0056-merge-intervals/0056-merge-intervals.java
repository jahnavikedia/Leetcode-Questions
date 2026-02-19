class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> op = new ArrayList<>();
        op.add(intervals[0]);
        int j=0;
        for(int i=1;i<n;i++)
        {
            if(op.get(j)[1]>=intervals[i][0])
            {
                op.get(j)[1] = Math.max(op.get(j)[1],intervals[i][1]);
            }
            else
            {
                op.add(intervals[i]);
                j++;
            }
        }
        return op.toArray(new int[op.size()][]);
    }
}