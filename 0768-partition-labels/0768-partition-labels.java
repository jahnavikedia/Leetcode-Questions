class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        int start=0,end=0;
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            end = Math.max(end,s.lastIndexOf(ch) );
            if(i==end)
            {
                result.add(end-start+1);
                start=i+1;
            }
        }
        return result;
    }
}