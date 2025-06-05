class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,max = -1,maxFreq=-1;
        Map<Character,Integer> map = new HashMap<>();
        while(j<s.length())
        {
            char c = s.charAt(j);
            map.put(c,map.getOrDefault(c,0)+1);
            maxFreq = Math.max(maxFreq, map.get(c));
            if((j-i+1)-maxFreq <= k)
            {
                max = Math.max(max,j-i+1);
                j++;
            }
            else if((j-i+1) - maxFreq > k)
            {
                while((j-i+1) - maxFreq > k)
                {
                    char temp = s.charAt(i);
                    map.put(temp,map.get(temp)-1);
                    i++;
                    if((j-i+1)-maxFreq == k)
                    {
                        max = Math.max(max,j-i+1);
                    }
                }
                j++;
            }
        }
        return max;
    }
}