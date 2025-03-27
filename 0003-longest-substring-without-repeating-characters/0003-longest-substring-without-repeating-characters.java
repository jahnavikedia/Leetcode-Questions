class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int i=0,j=0,max = 0;
        while(j<s.length())
        {
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()==j-i+1)
            {
                max=Math.max(max,j-i+1);
                j++;
            }
            else if(map.size()<j-i+1)
            {
                while(map.size()<j-i+1)
                {
                    char c = s.charAt(i);
                    map.put(c,map.getOrDefault(c,0)-1);
                    if(map.get(c)==0)
                    {
                        map.remove(c);
                    }
                    i++;
                }
                if(map.size()==j-i+1)
                {
                    max=Math.max(max,j-i+1);
                }
                j++;
            }
        }
        return max;
    }
}