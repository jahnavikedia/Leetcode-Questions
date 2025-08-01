class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int n = intervals.length;
        List<int[]> op = new ArrayList<>();
        int j=0;
        op.add(intervals[0]);
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