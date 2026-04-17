class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int op[] = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int rem = target-nums[i];
            if(map.containsKey(rem))
            {
                op[0] = i;
                op[1] = map.get(rem);
                return op;
            }
            map.put(nums[i],i);
        }
        return op;
    }
}