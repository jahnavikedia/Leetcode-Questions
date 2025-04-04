class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0)
        {
            return new ArrayList<>();
        }
        Map<String,ArrayList<String>> map  = new HashMap<>();
        for(String s : strs)
        {
            char ch[] = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(map.containsKey(key))
            {
                map.get(key).add(s);
            }
            else
            {
                map.put(key,new ArrayList<>());
                map.get(key).add(s);
            }
        }
        return new ArrayList<>(map.values());
    }
}