class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int max=-1;
       for(int pile:piles) max=Math.max(max,pile);
       int start = 1, end=max;
       int minCount = 0;
       while(start<=end)
       {
        int mid = start+(end-start)/2;
        if(solve(mid,piles,h)==true)
        {
            minCount = mid;
            end = mid-1;
        }
        else start=mid+1;
       }
       return minCount;
    }

    public boolean solve(int res, int piles[], int h)
    {
        long count=0;
        for(int pile:piles)
        {
            count+=(int)Math.ceil((double)pile/res);
        }
        if(count>h) return false;
        return true;
    }
}