class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        int op[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            while(!stack.isEmpty() && temp[stack.peek()]<=temp[i]) stack.pop();
            if(stack.isEmpty()) op[i] = 0;
            else op[i] = stack.peek()-i;
            stack.push(i);
        }
        return op;
    }
}