class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n= nums.length;
        Set<List<Integer>> op = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0) break;
            int j=i+1;
            int k = n-1;
            while(j<k)
            {
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    op.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if(sum<0) j++;
                else k--;  
            }
        }
        return new ArrayList<>(op);
    }
}