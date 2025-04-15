class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> op = new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int k =j+1;
                int l = n-1;
                while(k<l)
                {
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum==target)
                    {
                        op.add(Arrays.asList(nums[i],nums[j],nums[k],nums[l]));
                        k++;
                        l--;
                    }
                    else if(sum<target) k++;
                    else l--;
                }
            }
        }
        return new ArrayList<>(op);
    }
}