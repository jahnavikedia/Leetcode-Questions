class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray())
        {
            if(ch!=']') stack.push(ch);
            else
            {
                StringBuilder substr = new StringBuilder();
                while(stack.peek()!='[') substr.insert(0,stack.pop());
                stack.pop();
                StringBuilder k = new StringBuilder();
                while(!stack.isEmpty()&&Character.isDigit(stack.peek())) k.insert(0,stack.pop());
                int repeat = Integer.parseInt(k.toString());
                String repeated = substr.toString().repeat(repeat);
                for(char c:repeated.toCharArray()) stack.push(c);
            }
        }
        StringBuilder result = new StringBuilder();
        for(char c: stack) result.append(c);
        return result.toString();
    }
}