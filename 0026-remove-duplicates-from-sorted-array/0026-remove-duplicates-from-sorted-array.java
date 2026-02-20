class Solution {
    public int removeDuplicates(int[] nums) {
        int read=0,write=0;
        int n = nums.length;
        while(read<n)
        {
            int count =0;
            int curr = nums[read];
            while(read<n && nums[read]==curr)
            {
                count++;
                read++;
            }
            nums[write++]=curr;
        }
        return write;
    }
}