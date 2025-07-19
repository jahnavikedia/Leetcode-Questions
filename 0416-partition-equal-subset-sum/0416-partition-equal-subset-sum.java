class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num : nums) sum = sum+num;
        if(sum%2!=0) return false;
        return subsetSum(nums,sum/2);
    }
    private boolean subsetSum(int nums[],int sum)
    {
        int n = nums.length;
        boolean t[] = new boolean[sum+1];
        t[0] = true;
        for(int num:nums)
        {
            for(int i=sum;i>=num;i--)
            {
                t[i] = t[i] || t[i-num];
            }
        }
        return t[sum];
    }
}