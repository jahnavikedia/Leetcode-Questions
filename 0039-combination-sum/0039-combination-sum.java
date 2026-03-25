class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, target, res, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(int nums[], int target, List<List<Integer>> res, int start, List<Integer> curr)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<nums.length;i++)
        {
            if(nums[i]>target) break;
            curr.add(nums[i]);
            backtrack(nums,target-nums[i],res,i, curr);
            curr.remove(curr.size()-1);
        }
    }
}