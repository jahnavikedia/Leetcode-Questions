class Solution {
    public String minWindow(String s, String t) {
        int m = t.length(); int n = s.length();
        if(m>n) return "";
        Map<Character,Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c,0)+1);
        int count = map.size();
        int min = Integer.MAX_VALUE;
        int i=0,j=0,start=0;
        while(j<n)
        {
            char c = s.charAt(j);
            if(map.containsKey(c))
            {
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) count--;
            }
            while(count==0)
            {
                if(j-i+1 < min)
                {
                    min=j-i+1;
                    start=i;
                }
                char ch = s.charAt(i);
                if(map.containsKey(ch))
                {
                    if(map.get(ch)==0) count++;
                    map.put(ch,map.get(ch)+1);
                }
                i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE ? "": s.substring(start,start+min);
    }
}