class Solution {
    public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++)
        {
            curr = Math.max(nums[i],nums[i]+curr);
            max = Math.max(curr,max);
        }
        return max;
    }
}