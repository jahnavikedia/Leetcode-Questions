class Solution {
    String phoneMap[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.isEmpty()) return res;
        backtrack(digits,res,0,"");
        return res;
    }
    public void backtrack(String digits, List<String> res, int idx, String curr)
    {
        if(idx == digits.length())
        {
            res.add(curr);
            return;
        }
        String letters = phoneMap[digits.charAt(idx)-'0'];
        for(char letter : letters.toCharArray())
        {
            backtrack(digits,res,idx+1,curr+letter);
        }
    }
}