class Solution {
    public int minimumSize(int[] nums, int maxOp) {
        int max=-1;
        int n = nums.length;
        for(int num: nums) max = Math.max(num,max);
        int start=1, end= max;
        int res = max;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(canDivide(nums,maxOp,mid))
            {
                res = mid; end=mid-1;
            }
            else start=mid+1;
        }
        return res;
    }
    public boolean canDivide(int nums[],int maxOp, int limit)
    {
        int ops=0;
        for(int num: nums)
        {
            ops+=(num-1)/limit;
            if(ops > maxOp) return false;
        }
        return true;
    }
}