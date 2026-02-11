class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int i=0,j=0;
        int maxCount = 0;
        while(j<n)
        {
            char ch = s.charAt(j);
            while(map.containsKey(ch))
            {
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i))==0) map.remove(s.charAt(i));
                i++;
            }
            map.put(ch,1);
            maxCount = Math.max(maxCount, j-i+1);
            j++;
        }
        return maxCount;
    }
}