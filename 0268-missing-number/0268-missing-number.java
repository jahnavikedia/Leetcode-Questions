class Solution {
    public int missingNumber(int[] nums) {
        int n= nums.length;
        int a = n;
        for(int i=0;i<nums.length;i++)
        {
            a = a ^ i ^ nums[i];
        }
        return a;
    }
}