class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()) return "";
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<t.length();i++)
        {
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }
        int i=0,j=0,count=map.size(),min = Integer.MAX_VALUE;
        int start=0;
        while(j<s.length())
        {
            char ch = s.charAt(j);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) count--;
            }
            if(count == 0)
            {
                while(count==0)
                {
                    if(min > j-i+1)
                    {
                        min = j-i+1;
                        start = i;
                    }
                    if(map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        if(map.get(s.charAt(i)) > 0) count++;
                    }
                    i++;
                }
            }
            j++;
        }
        if(min == Integer.MAX_VALUE) return "";
        return (s.substring(start,min+start));
    }
}