class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int min=Integer.MAX_VALUE,sum=0,i=0,j=0;
        while(j<nums.length)
        {
            sum = sum+nums[j];
            if(sum == target) 
            {
                min = Math.min(min,j-i+1);
                sum = sum-nums[i];
                i++;
            }
            else if(sum > target)
            {
                min = Math.min(min,j-i+1);
                while(sum > target)
                {
                    min = Math.min(min,j-i+1);
                    sum = sum-nums[i];
                    i++;
                }
                if(sum == target) 
                {
                min = Math.min(min,j-i+1);
                sum = sum-nums[i];
                i++;
                }
            }
            j++;
        }
        if(min == Integer.MAX_VALUE) return 0;
        return min;
    }
}