class Solution {
    public int removeDuplicates(int[] nums) {
        int read=0, write=0;
        int n = nums.length;
        while(read<n)
        {
            int curr = nums[read];
            while(read<n && nums[read]==curr) read++;
            nums[write++] = curr;
        }
        return write;
    }
}