class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total=0;
        for(int num: nums) total+=num;
        if(total%k != 0) return false;
        Arrays.sort(nums);
        if(nums[nums.length-1] > total/k) return false;
        boolean used[] = new boolean[nums.length];
        return backtrack(nums,total/k,0,0,used,k);
    }
    private boolean backtrack(int nums[], int target, int start, int currSum, boolean used[], int k)
    {
        if(k==0) return true;
        if(currSum == target)
        {
            return backtrack(nums,target,0,0,used,k-1);
        }
        for(int i=start;i<nums.length;i++)
        {
            if(used[i]) continue;
            if(currSum+nums[i] > target) continue;
            used[i] = true;
            if(backtrack(nums,target, i+1,currSum+nums[i],used, k)) return true;
            used[i] = false;
            if(currSum == 0) break; 
        }
        return false;
    }
}