class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int start = 0,end = n-1;
        int res = nums[0];
        while(start<=end)
        {
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[end]) start=mid+1;
            else
            {
                res = Math.min(nums[mid],res);
                end= mid-1;
            }
        }
        return res;
    }
}