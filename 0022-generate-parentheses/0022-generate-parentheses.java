class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n,res,"",0,0);
        return res;
    }
    public void backtrack(int n, List<String> res, String op, int open, int close)
    {
        if(op.length()==2*n)
        {
            res.add(op);
            return;
        }
        if(open<n) backtrack(n,res,op+"(",open+1,close);
        if(close<open) backtrack(n,res,op+")",open,close+1);
    }
}