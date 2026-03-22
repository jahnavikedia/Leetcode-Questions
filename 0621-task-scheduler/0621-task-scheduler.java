class Solution {
    public int leastInterval(char[] tasks, int n) {
        int fre[] = new int[26];
        for(char task : tasks)
        {
            fre[task-'A']++;
        }
        int max=0;
        for(int f: fre) max = Math.max(max,f);
        int countMaxFreq = 0;
        for(int f:fre) if(f==max)countMaxFreq++;
        int minTime = (max-1)*(n+1) + countMaxFreq;
        return Math.max(minTime,tasks.length);
    }
}