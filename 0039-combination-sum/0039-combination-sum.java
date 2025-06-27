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
        if(target < 0 || start == nums.length ) return;
        temp.add(nums[start]);
        backtrack(start, nums, target - nums[start], result, temp);
        temp.remove(temp.size()-1);

        backtrack(start+1,nums,target,result,temp);
    }
}