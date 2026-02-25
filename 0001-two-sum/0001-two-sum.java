class Solution {
    public int[] twoSum(int[] nums, int target) {
        int op[] = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            int diff = target - nums[i];
            if(map.containsKey(diff))
            {
                op[0] = i;
                op[1] = map.get(diff);
                return op;
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}