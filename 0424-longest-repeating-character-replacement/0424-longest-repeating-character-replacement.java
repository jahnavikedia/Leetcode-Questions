class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,maxFreq=0,max=0;
        Map<Character,Integer> map = new HashMap<>();
        while(j<s.length())
        {
            char curr = s.charAt(j);
            map.put(curr,map.getOrDefault(curr,0)+1);
            maxFreq = Math.max(maxFreq,map.get(curr));
            if((j-i+1) - maxFreq <= k)
            {
                max = Math.max(j-i+1,max);
                j++;
            }
            else if((j-i+1) - maxFreq > k)
            {
                while((j-i+1) - maxFreq > k)
                {
                    char temp = s.charAt(i);
                    map.put(temp,map.get(temp)-1);
                    i++;
                    if((j-i+1) - maxFreq == k)
                    {
                        max = Math.max(j-i+1,max);
                    }
                }
                j++;
            }
        }
        return max;
    }
}