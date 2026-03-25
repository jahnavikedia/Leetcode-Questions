class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        boolean visited[] = new boolean[nums.length];
        backtrack(nums,op,new ArrayList<>(),visited);
        return op;
    }
    public void backtrack(int nums[],List<List<Integer>> res, List<Integer> curr, boolean visited[])
    {
        if(curr.size() == nums.length)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(visited[i]==true) continue;
            visited[i] = true;
            curr.add(nums[i]);
            backtrack(nums,res,curr,visited);
            visited[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}