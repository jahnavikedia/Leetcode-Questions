class Solution {
    public int findDuplicate(int[] nums) {
       int i=0;
       int size = nums.length;
       while(i<size)
       {
        if(nums[i]!=nums[nums[i]-1])
        {
            int correctIndex = nums[i] - 1;
            int temp = nums[i];
            nums[i] = nums[correctIndex];
            nums[correctIndex] = temp;
        } 
        else
        {
            i++;
        }
       } 
       for(i=0;i<size;i++)
       {
        if(nums[i]!=i+1)
        {
            return nums[i];
        }
       }
       return 0;
    }
}