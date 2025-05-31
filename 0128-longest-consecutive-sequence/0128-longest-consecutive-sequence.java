class Solution {
    public int longestConsecutive(int[] nums) {
        int max=0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        {
            set.add(num);
        }
        for(int num : nums)
        {
            int count=1;
            int j = num;
            while(set.contains(--j)) 
            {
                count++;
                set.remove(j);
            }
            j=num;
            while(set.contains(++j)) 
            {
                set.remove(j);
                count++;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}