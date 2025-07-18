class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        int n = nums.length;
        int left = 1;
        int right = 1;
        for(int i=0;i<n;i++)
        {
            left = left==0?1:left;
            right = right==0?1:right;
            left = left * nums[i];
            right = right * nums[n-i-1];
            ans = Math.max(ans,Math.max(left,right));
        }
        return ans;
    }
}