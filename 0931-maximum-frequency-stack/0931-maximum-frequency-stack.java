class FreqStack {
    Map<Integer,Integer> freqMap;
    Map<Integer,Stack<Integer>> maxFreqStack;
    int maxFreq;
    public FreqStack() {
        freqMap = new HashMap<>();
        maxFreqStack = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int f = freqMap.getOrDefault(val,0)+1;
        freqMap.put(val,f);
        maxFreq = Math.max(maxFreq, f);
        maxFreqStack.computeIfAbsent(f,z->new Stack<>()).push(val);
    }
    
    public int pop() {
        Stack<Integer> stack = maxFreqStack.get(maxFreq);
        int val = stack.pop();
        if(stack.isEmpty()) maxFreq--;
        freqMap.put(val,freqMap.get(val)-1);
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */