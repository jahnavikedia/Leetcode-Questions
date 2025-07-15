class MinStack {
    public Stack<Long> stack = new Stack<>();
    public static long minEle;
    public MinStack() {
        
    }
    
    public void push(long val) {
        if(stack.isEmpty())
        {
            stack.push(val);
            minEle = val;
        }
        else if(val>=minEle) stack.push(val);
        else
        {
            stack.push(2*val-minEle);
            minEle = val;
        }
    }
    
    public void pop() {
       if(stack.isEmpty()) return;
       else
       {
        if(stack.peek()>=minEle) stack.pop();
        else 
        {
            minEle = 2*minEle - stack.pop();
        }
       } 
    }
    
    public long top() {
        if(stack.isEmpty()) return -1;
        else
        {
            if(stack.peek()>=minEle) return stack.peek();
            else return minEle;
        }
    }
    
    public long getMin() {
        if(stack.isEmpty()) return -1;
        return minEle;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */