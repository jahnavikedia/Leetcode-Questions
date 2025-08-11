class Solution {
    public int splitArray(int[] nums, int k) {
        int max = -1,sum=0;
        for(int num : nums)
        {
            max = Math.max(max,num);
            sum+= num;
        }
        long start = max;long end = sum;long mid;
        long ans = -1;
        while(start<=end)
        {
            mid = start+(end-start)/2;
            if(isSolvable(nums,k,mid))
            {
                ans = mid;
                end= mid-1;
            }
            else start=mid+1;
        }
        return (int)ans;
    }
    private boolean isSolvable(int nums[],int k, long cap)
    {
        int parts=1;
        long sum=0;
        for(int num : nums)
        {
            if(num+sum <= cap)sum+=num;
            else
            {
                parts++;
                sum=num;
                if(parts>k) return false;
            }
        }
        return true;
    }
}