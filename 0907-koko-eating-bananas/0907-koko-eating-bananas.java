class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=-1;
        for(int pile : piles) 
        {
            max = Math.max(max,pile);
        }
        int start = 1; int end = max;
        int res=0;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(solve(mid,h,piles)==true)
            {
                res = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
       return res; 
    }
    public boolean solve(int mid, int h,int piles[])
    {
        long count=0;
        for(int pile : piles)
        {
            count += (int) Math.ceil((double) pile / mid);
        }
        if(count>h) return false;
        return true;
    }
}