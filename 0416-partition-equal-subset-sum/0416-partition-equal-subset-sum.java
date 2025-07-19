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
        boolean t[][] = new boolean[n+1][sum+1];
        for(int j=0;j<=sum;j++)t[0][j] = false;
        for(int i=0;i<=n;i++) t[i][0] = true;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                if(nums[i-1]<=j)
                t[i][j] = t[i-1][j] || t[i-1][j-nums[i-1]];
                else t[i][j] = t[i-1][j];
            }
        }
        return t[n][sum];
    }
}