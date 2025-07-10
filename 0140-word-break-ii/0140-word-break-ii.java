class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>(wordDict);
        backtrack(0,result,set,s, new ArrayList<>());
        return result;
    }
    private void backtrack(int start, List<String> result, Set<String> set, String s, ArrayList<String> temp)
    {
        if(start == s.length())
        {
            result.add(String.join(" ", temp));
            return;
        }
        for(int end=start+1;end<=s.length();end++)
        {
            String word=s.substring(start,end);
            if(set.contains(word))
            {
                temp.add(word);
                backtrack(end, result, set, s, temp);
                temp.remove(temp.size()-1);
            }
        }
    }
}