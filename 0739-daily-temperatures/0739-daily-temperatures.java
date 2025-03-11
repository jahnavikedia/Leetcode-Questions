public class Pair{
    int ele;
    int index;
    Pair(int ele, int index){
        this.ele = ele;
        this.index = index;
    }
}
class Solution {
    public int[] dailyTemperatures(int[] arr) {
        int op[] = new int[arr.length];
        Stack<Pair> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            if(stack.isEmpty())
            {
                op[i] = 0;
            }
            else if(arr[i]<stack.peek().ele)
            {
                op[i] = stack.peek().index - i;
            }
            else if(arr[i]>=stack.peek().ele)
            {
                while(!stack.isEmpty() && arr[i]>=stack.peek().ele)
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    op[i] = 0;
                }
                else{
                    op[i] = stack.peek().index - i;
                }
            }
            stack.push(new Pair(arr[i],i));
        }
        return op; 
    }
}