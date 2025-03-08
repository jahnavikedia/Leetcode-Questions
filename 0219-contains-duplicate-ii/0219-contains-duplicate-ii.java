class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int count=0;
        int i=0,j=0;
        while(j<nums.length)
        {
            if(map.containsKey(nums[j]))
            {
                map.put(nums[j],map.get(nums[j])+1);
            }
            else if(!map.containsKey(nums[j]))
            {
                map.put(nums[j],1);
                count++;
            }
            if((j-i+1)<=k+1)
            {
                if((j-i+1)!=count && j!=i) 
                {
                    return true;
                }
                j++;
                continue;
            }
            else if((j-i+1)>k+1)
            {
                while((j-i+1)>k+1)
                {
                    if(map.containsKey(nums[i]))
                    {
                        map.put(nums[i],map.get(nums[i])-1);
                        if(map.get(nums[i])==0)
                        {
                            map.remove(nums[i]);
                            count--;
                        }
                    }
                    i++;
                }
                if(j-i+1!=count && j!=i)
                {
                    return true;
                }
                j++;
            }
        }
        return false;
    }
}