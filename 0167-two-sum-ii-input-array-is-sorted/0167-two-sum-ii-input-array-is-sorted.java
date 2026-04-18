class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int op[] = new int[2];
        int i=0,j=n-1;
        while(i<j)
        {
            int sum = nums[i]+nums[j];
            if(sum==target)
            {
                op[0] = i+1; op[1] = j+1; break;
            }
            else if(sum<target) i++;
            else j--;
        }
        return op;
    }
}