class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int op[] = new int[n];
        op[0] = 1;
        for(int i=1;i<n;i++) op[i] = nums[i-1]*op[i-1];
        int temp = nums[n-1];
        for(int i=n-2;i>=0;i--)
        {
            op[i] = op[i]*temp;
            temp = temp * nums[i];
        }
        return op;
    }
}