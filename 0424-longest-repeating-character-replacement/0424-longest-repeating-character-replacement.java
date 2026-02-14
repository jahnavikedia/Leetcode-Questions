class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxCount = -1, max=-1;
        int n = s.length(), i=0, j=0;
        while(j<n)
        {
            char c = s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            maxCount = Math.max(maxCount,map.get(c));
            if((j-i+1)-maxCount <= k)
            {
                max = Math.max(max,j-i+1);
            }
            else
            {
                while((j-i+1)-maxCount > k)
                {
                    char d = s.charAt(i);
                    map.put(d, map.get(d)-1);
                    i++;
                    if((j-i+1)-maxCount ==k)
                    {
                        max = Math.max(max, j-i+1);
                    }
                }
            }
            j++;
        }
        return max;
    }
}