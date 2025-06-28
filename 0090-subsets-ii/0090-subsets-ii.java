class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        backtrack(nums,0,result,new ArrayList<>());
        return new ArrayList<>(result);
    }
    private void backtrack(int nums[], int start, Set<List<Integer>> result, ArrayList<Integer> temp)
    {
        result.add(new ArrayList<>(temp));
        for(int i=start;i<nums.length;i++)
        {
            temp.add(nums[i]);
            backtrack(nums,i+1,result,temp);
            temp.remove(temp.size()-1);
        }
    }
}