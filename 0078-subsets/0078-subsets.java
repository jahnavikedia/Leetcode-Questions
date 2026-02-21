class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        backtrack(nums, res, new ArrayList<>(),0);
        return res;
    }

    public void backtrack(int nums[], List<List<Integer>> res, ArrayList<Integer> op, int index)
    {
        res.add(new ArrayList<>(op));
        for(int i=index;i<nums.length;i++)
        {
            op.add(nums[i]);
            backtrack(nums, res, op, i+1);
            op.remove(op.size()-1);
        }
    }
}