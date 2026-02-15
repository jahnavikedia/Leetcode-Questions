class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        if(m>n) return false;
        if(s1.equals(s2)) return true;
        Map<Character,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0;i<m;i++)
        {
            char c = s1.charAt(i);
            if(map.containsKey(c)) map.put(c,map.get(c)+1);
            else
            {
                map.put(c,1);
                count++;
            }
        }
        int i=0,j=0;
        while(j<n)
        {
            char c = s2.charAt(j);
            if(map.containsKey(c))
            {
                map.put(c, map.get(c)-1);
                if(map.get(c)==0) count--;
            }
            if(j-i+1 == m)
            {
                if(count == 0) return true;
                char ch = s2.charAt(i);
                if(map.containsKey(ch))
                {
                    if(map.get(ch)==0) count++;
                    map.put(ch, map.get(ch)+1);
                }
                i++;
            } 
            j++;
        }
        return false;
    }
}