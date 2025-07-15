class Solution {
    public int evalRPN(String[] tokens) {
        String operand = "";
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens)
        {
            if(token.equals("+"))
            {
                int first = stack.pop();
                int second = stack.pop();
                int ans = first+second;
                stack.push(ans);
            }
            else if(token.equals("-"))
            {
                int first = stack.pop();
                int second =stack.pop();
                int ans = second-first;
                stack.push(ans);
            }
            else if(token.equals("*"))
            {
                int first = stack.pop();
                int second = stack.pop();
                int ans = second*first;
                stack.push(ans);
            }
             else if(token.equals("/"))
            {
                int first = stack.pop();
                int second = stack.pop();
                int ans = second/first;
                stack.push(ans);
            }
            else
            {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}