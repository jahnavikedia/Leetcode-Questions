class Pair
{
    int num;
    int span;
    Pair(int num, int span)
    {
        this.num = num;
        this.span = span;
    }
}
class StockSpanner {
    public Stack<Pair> stack = new Stack<Pair>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek().num <= price) span = span + stack.pop().span;
        stack.push(new Pair(price,span));
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */