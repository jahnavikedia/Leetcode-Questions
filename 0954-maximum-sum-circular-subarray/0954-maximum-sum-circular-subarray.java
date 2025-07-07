class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum=nums[0],currMax = 0;
        int total = 0;
        int minSum = nums[0],currMin = 0;
        for(int num:nums)
        {
            currMax = Math.max(currMax+num , num);
            maxSum = Math.max(currMax,maxSum);
            currMin = Math.min(currMin+num,num);
            minSum = Math.min(currMin,minSum);
            total = total + num;
        }
        if(maxSum<0) return maxSum;
        return Math.max(maxSum,total-minSum);
    }
}