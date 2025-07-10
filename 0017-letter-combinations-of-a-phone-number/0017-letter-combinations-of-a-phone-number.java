class Solution {
    private static final Map<Character,String> map = new HashMap<>();
    static{
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty()) return result;
        backtrack(0,digits, result,new ArrayList<>());
        return result;
    }
    private void backtrack(int start, String s, List<String> result, ArrayList<Character>path)
    {
        if(start == s.length())
        {
            StringBuilder sb = new StringBuilder();
            for(char ch : path) sb.append(ch);
            result.add(sb.toString());
            return;
        }
        String letters = map.get(s.charAt(start));
        for(char ch : letters.toCharArray())
        {
            path.add(ch);
            backtrack(start+1,s,result,path);
            path.remove(path.size()-1);
        }
    }
}