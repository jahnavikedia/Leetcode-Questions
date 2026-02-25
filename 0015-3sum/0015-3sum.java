class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> op = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            if(nums[i]>0) break;
            int target = -nums[i]; 
            int j=i+1, k = n-1;
            while(j<k)
            {
                int sum = nums[j]+nums[k];
                if(sum==target)
                {
                    op.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    while(j<k && nums[j]==nums[j+1]) j++;
                    while(j<k && nums[k]==nums[k-1]) k--;
                    j++; k--;
                }
                else if(sum<target) j++;
                else k--;
            }
        }
                    return op;
    }
}