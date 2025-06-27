class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums, target, result, new ArrayList<Integer>());
        return result;
    }
    private void backtrack(int start, int nums[], int target, List<List<Integer>> result, ArrayList<Integer> temp)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++)
        {
            if(target<0) break;
            temp.add(nums[i]);
            backtrack(i,nums,target-nums[i],result,temp);
            temp.remove(temp.size()-1);
        }
    }
}