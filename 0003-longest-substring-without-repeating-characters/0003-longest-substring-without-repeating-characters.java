class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int i=0,j=0;
        int max=0;
        while(j<n)
        {
            char ch = s.charAt(j);
            while(map.containsKey(ch))
            {
                char c= s.charAt(i);
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) map.remove(c);
                i++;
            }
            map.put(ch,1);
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}