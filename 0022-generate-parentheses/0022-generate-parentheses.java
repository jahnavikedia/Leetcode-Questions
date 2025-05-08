class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n, close = n;
        List<String> arr = new ArrayList<>();
        String op = "";
        solve(arr,open,close, op);
        return arr;
    }
    public void solve(List<String> arr, int open, int close, String op )
    {
        if(open == 0 && close == 0) 
        {
            arr.add(op);
            return;
        }
        if(open !=0) 
        {
            String op1 = op + '(';
            solve(arr,open-1,close,op1);
        }
        if(close > open)
        {
            String op2 = op + ')';
            solve(arr,open,close-1, op2);
        }
        return;
        
    }

}