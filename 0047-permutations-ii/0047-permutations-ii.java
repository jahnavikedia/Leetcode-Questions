class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean used[] = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums,result, new ArrayList<>(),used);
        return result;
    }
    private void backtrack(int nums[],List<List<Integer>> result,ArrayList<Integer> temp, boolean used[]  )
    {
        if(temp.size() == nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            temp.add(nums[i]);
            used[i] = true;
            backtrack(nums,result,temp,used);
            used[i]=false;
            temp.remove(temp.size()-1);
        }
    }
}