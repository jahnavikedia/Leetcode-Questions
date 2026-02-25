class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        int n = nums.length;
        boolean used[] = new boolean[n];
        backtrack(nums,used,n, op, new ArrayList<>());
        return op;
    }
    public void backtrack(int nums[], boolean used[], int n, List<List<Integer>> op, List<Integer> curr)
    {
        if(curr.size()==n)
        {
            op.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<n;i++)
        {
            if(used[i]) continue;
            used[i] = true;
            curr.add(nums[i]);
            backtrack(nums,used,n,op,curr);
            used[i] = false;
            curr.remove(curr.size()-1);
        }
    }
}