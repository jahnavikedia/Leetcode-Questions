class Solution {
    public int subarraySum(int[] arr, int k) {
        int sum=0,count=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<arr.length;i++)
        {
            sum = sum+arr[i];
            if(map.containsKey(sum-k))
            {
                count += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}