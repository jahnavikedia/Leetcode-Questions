class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean used[] = new boolean[n];
        backtrack(nums,n,res,new ArrayList<Integer>(),used);
        return res;
    }
    public void backtrack(int nums[], int n, List<List<Integer>> res, ArrayList<Integer> curr, boolean used[])
    {
        if(curr.size()==n)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(used[i]==true) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums,n, res, curr,used);
            curr.remove(curr.size()-1);
            used[i] = false;
        }
    }
}