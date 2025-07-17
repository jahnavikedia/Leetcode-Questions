class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int t[] = new int[n];
        if(n<2) return nums[0];
        t[0] = nums[0];
        t[1] = Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++)
        {
            t[i] = Math.max(nums[i]+t[i-2], t[i-1]);
        }
        return t[n-1];
    }
}