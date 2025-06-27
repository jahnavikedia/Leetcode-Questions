class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, result,new ArrayList<Integer>());
        return result;
    }
    private void backtrack(int nums[], int start, List<List<Integer>> result, ArrayList<Integer> temp)
    {
        result.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++)
        {
            temp.add(nums[i]);
            backtrack(nums,i+1,result, temp);
            temp.remove(temp.size()-1);
        }
    }
}