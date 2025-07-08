class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumgas=0, sumcost=0;
        for(int i=0;i<gas.length;i++)
        {
           sumgas=sumgas+gas[i];
           sumcost = sumcost+cost[i]; 
        }
        if(sumgas<sumcost) return -1;
        int total=0,start=0;
        for(int i=0;i<gas.length;i++)
        {
            total = total + (gas[i] - cost[i]);
            if(total<0)
            {
                total=0;
                start = i+1;
            }
        }
        return start;
    }
}