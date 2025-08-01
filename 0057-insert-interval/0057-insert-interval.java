class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int i=0,j=0;
        int result[][] = new int[n+1][2];
        while(i<n && intervals[i][1]<newInterval[0])
        {
            result[j] = intervals[i];
            j++;
            i++;
        }
        while(i<n && intervals[i][0]<=newInterval[1])
        {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        result[j] = newInterval;
        j++;
        while(i<n)
        {
            result[j] = intervals[i];
            j++;
            i++;
        }
        return Arrays.copyOf(result,j);
    }
}