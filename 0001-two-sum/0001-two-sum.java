class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int op[] = new int[2];
        int n = nums.length;
        for(int i=0;i<n;i++)
        {
            int rem = target-nums[i];
            if(map.containsKey(rem))
            {
                op[0] = map.get(rem);
                op[1] = i;
                return op;
            }
            map.put(nums[i],i);
        }
        return op;

    }
}