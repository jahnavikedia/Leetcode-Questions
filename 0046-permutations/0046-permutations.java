class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,0,result, new ArrayList<>());
        return result;
    }
    private void backtrack(int nums[],int start,List<List<Integer>> result,ArrayList<Integer> temp  )
    {
        if(start == nums.length)
        {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=start;i<nums.length;i++)
        {
            int num = nums[i];
            temp.add(num);
            swap(nums,start,i);
            backtrack(nums,start+1,result,temp);
            temp.remove(temp.size()-1);
            swap(nums,start,i);
        }
    }
    private void swap(int nums[], int i,int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}