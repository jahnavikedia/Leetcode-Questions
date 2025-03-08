class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            int j = nums[i],count=1;
            while(set.contains(--j))
            {
                count++;
                set.remove(j);
            }
            j=nums[i];
            while(set.contains(++j))
            {
                count++;
                set.remove(j);
            }
            max=Math.max(max,count);
        }
        return max;
    }
}