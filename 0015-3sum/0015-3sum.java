class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>0) break;
            int target = -nums[i];
            int j=i+1,k=n-1;
            while(j<k)
            {
                int sum = nums[j]+nums[k];
                if(sum == target){
                    set.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                } 
                else if(sum<target) j++;
                else k--;
            }
        }
        return new ArrayList<>(set);
    }
}