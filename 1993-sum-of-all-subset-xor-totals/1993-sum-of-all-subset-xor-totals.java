class Solution {
    public int subsetXORSum(int[] nums) {
        return backtrack(0,0,nums);
    }
    public int backtrack(int start, int xor, int nums[])
    {
        if(start == nums.length) return xor;
        int include = backtrack(start+1, xor ^ nums[start], nums);
        int exclude = backtrack(start+1, xor, nums );
        return include + exclude;
    }
}