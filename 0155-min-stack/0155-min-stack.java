class MinStack {
    public Stack<Long> stack;
    public long minEle;
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(long val) {
        if(stack.isEmpty())
        {
            stack.push(val); minEle = val;
        }
        else{
        if(val<minEle)
        {
            stack.push(2*val-minEle);
            minEle = val;
        }
        else stack.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek()<minEle) minEle = 2*minEle-stack.pop();
        else stack.pop();
    }
    
    public long top() {
        if(stack.peek()<minEle) return minEle;
        return stack.peek();
    }
    
    public long getMin() {
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