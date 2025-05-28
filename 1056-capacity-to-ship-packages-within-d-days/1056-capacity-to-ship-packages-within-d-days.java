class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum=0,max=-1;
        for(int i=0;i<weights.length;i++)
        {
            sum = weights[i]+sum;
            max = Math.max(weights[i],max);
        }
        int start=max,end = sum,mid, ans=-1;
        while(start<=end)
        {
            mid = start+(end-start)/2;
            if(solve(weights,mid,days)==true)
            {
                ans = mid;
                end = mid-1;
            }
            else
            {
                start = mid+1;
            }
        }
        return ans;
    }
    public boolean solve(int weights[], int cap, int days)
    {
        int count=1,sum=0;
        for(int i=0;i<weights.length;i++)
        {
            sum = sum+weights[i];
            if(sum>cap)
            {
                count++;
                sum = weights[i];
            }
            if(count>days) return false;
        }
        return true;
    }
}