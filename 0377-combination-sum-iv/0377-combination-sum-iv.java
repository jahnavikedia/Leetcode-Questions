class Solution {
    public int combinationSum4(int[] nums, int sum) {
        int n = nums.length;
        int t[] = new int[sum+1];
        t[0] = 1;
        for(int i=1;i<=sum;i++)
        {
            for(int num:nums)
            {
                if(num<=i) t[i]=t[i]+t[i-num]; 
            }
        }
        return t[sum];
    }
}