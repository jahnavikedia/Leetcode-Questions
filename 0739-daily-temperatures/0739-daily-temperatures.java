class Solution {
    class Pair{
        int ele, index;
        Pair(int ele, int index)
        {
            this.ele=ele;
            this.index = index;
        }
    }
    public int[] dailyTemperatures(int[] temp) {
        if(temp.length==1) return new int[]{0};
        int n = temp.length;
        Stack<Pair> stack = new Stack<>();
        int op[] = new int[n];
        for(int i=n-1;i>=0;i--)
        {
            if(stack.isEmpty()) op[i] = 0;
            else if(stack.peek().ele>temp[i]) op[i] = stack.peek().index-i;
            else
            {
                while(!stack.isEmpty() && stack.peek().ele<=temp[i]) stack.pop();
                if(stack.isEmpty()) op[i] = 0;
                else op[i] = stack.peek().index - i;
            }
            stack.push(new Pair(temp[i],i));
        }
        return op;
    }
}