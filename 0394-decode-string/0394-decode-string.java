class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray())
        {
            if(c != ']') stack.push(c);
            else
            {
                StringBuilder substr = new StringBuilder();
                while(stack.peek()!='[') substr.insert(0,stack.pop());
                stack.pop();
                StringBuilder k = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek()))
                    k.insert(0,stack.pop());
                int repeat = Integer.parseInt(k.toString());
                String repeated = substr.toString().repeat(repeat);
                for(char ch: repeated.toCharArray()) stack.push(ch);

            }
        }
        StringBuilder result = new StringBuilder();
        for(char ch : stack) result.append(ch);
        return result.toString();
    }
}