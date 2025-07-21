class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int diff = target;
        int n = nums.length;
        int sum=0;
        for(int i=0;i<n;i++) sum=sum+nums[i];
        if ((diff + sum) % 2 != 0 || diff > sum || diff < -sum) return 0;
        target = (diff+sum)/2;
        int t[][] = new int[n+1][target+1];
        t[0][0]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<=target;j++)
            {
                if(nums[i-1]<=j) t[i][j] = t[i-1][j] + t[i-1][j-nums[i-1]];
                else t[i][j] = t[i-1][j];
            }
        }
        return t[n][target];
    }
}