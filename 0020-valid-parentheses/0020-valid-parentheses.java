class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()==1) return false;
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') stack.push(c);
            else
            {
                if(stack.isEmpty()) return false;
                if(c == ')' && stack.peek() == '(') stack.pop();
                else if(c == ']' && stack.peek() == '[') stack.pop();
                else if(c == '}' && stack.peek() == '{') stack.pop();
                else return false;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}