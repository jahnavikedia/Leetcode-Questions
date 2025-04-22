class Solution {
    public int[] productExceptSelf(int[] nums) {
        int op[] = new int[nums.length];
        op[0] = 1;
        for(int i=1;i<nums.length;i++)
        {
            op[i] = nums[i-1]*op[i-1];
        }
        int temp =nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--)
        {
            op[i] = temp*op[i];
            temp = temp*nums[i];
        }
        return op;
    }
}