class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        boolean used[] = new boolean[n];
        backtrack(nums,n, res, new ArrayList<>(),used);
        return res;
    }

    public void backtrack(int nums[], int n, List<List<Integer>> res, ArrayList<Integer> curr, boolean used[])
    {
        if(curr.size() == n)
        {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums, n, res, curr, used);
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}