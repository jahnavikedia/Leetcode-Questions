class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> op = new ArrayList<>();
        backtrack(n,op,"",0,0);
        return op;
    }

    private void backtrack(int n, List<String> op, String curr, int open, int close)
    {
        if(curr.length()==2*n)
        {
            op.add(curr); return;
        }
        if(open<n) backtrack(n,op,curr+'(',open+1,close);
        if(close<open) backtrack(n,op,curr+')',open,close+1);
    }
}