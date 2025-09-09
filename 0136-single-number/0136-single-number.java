class Solution {
    public int singleNumber(int[] nums) {
        int temp = 0;
        int n = nums.length;
        for(int num : nums)
        {
            temp ^= num;
        }
        return temp;
    }
}