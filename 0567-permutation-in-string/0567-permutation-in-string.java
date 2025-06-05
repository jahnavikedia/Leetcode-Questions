class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        if(s1.equals(s2)) return true;
        int j=0,count=0; 
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++)
        {
            if(map.containsKey(s1.charAt(i)))
            {
                map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
            }
            else
            {
                map.put(s1.charAt(i),1);
                count++;
            }
        }
        int i=0,k = s1.length();
        while(j<s2.length())
        {
            char ch = s2.charAt(j);
            if(map.containsKey(ch))
            {
                map.put(ch,map.get(ch)-1);
                if(map.get(ch)==0) count--;
            }
            if(j-i+1 == k)
            {
                if(count==0) return true;
                if(map.containsKey(s2.charAt(i)))
                {
                    if(map.get(s2.charAt(i))==0) count++;
                    map.put(s2.charAt(i),map.get(s2.charAt(i))+1);
                }
                i++;
            }
            j++;
        }
        return false;

    }
}