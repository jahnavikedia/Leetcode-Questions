class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int t[] = new int[n];
        if(n<2) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        t[0] = nums[0];
        t[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<n-1;i++)
        {
            t[i] = Math.max(nums[i]+t[i-2], t[i-1]);
        }
        int t2[] = new int[n];
        t2[1] = nums[1];
        t2[2] = Math.max(nums[1], nums[2]);
        for(int i=3;i<n;i++)
        {
            t2[i] = Math.max(nums[i]+t2[i-2],t2[i-1]);
        }
        int ans = Math.max(t[n-2],t2[n-1]);
        return ans;
    }
}