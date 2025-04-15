class Solution {
    public int[] twoSum(int[] nums, int target) {
       int op[] = new int[2];
       int n=nums.length;
       int i=0,j= n-1;
       while(i<j)
       {
        int sum = nums[i]+nums[j];
        if(sum==target)
        {
            op[0] = i+1;
            op[1] = j+1;
            return op;
        }
        else if(sum<target) i++;
        else j--;
       }
       return op;
    }
}