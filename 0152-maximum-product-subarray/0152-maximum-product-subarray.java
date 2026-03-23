class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for(int i=1;i<n;i++)
        {
            int tempMax = max;
            max = Math.max(nums[i],Math.max(nums[i]*max, nums[i]*min));
            min = Math.min(nums[i],Math.min(nums[i]*tempMax, nums[i]*min));
            result = Math.max(max,result);
        }
        return result;
    }
}