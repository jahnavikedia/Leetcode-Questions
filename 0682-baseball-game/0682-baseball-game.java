class Solution {
    public int calPoints(String[] arr) {
        List<Integer> op = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--)
        {
            stack.push(arr[i]);
        }
        while(!stack.isEmpty())
        {
            if(stack.peek().equals("+"))
            {
                int first = op.get(op.size()-1);
                int second = op.get(op.size()-2);
                op.add(first+second);
            }
            else if(stack.peek().equals("D"))
            {
                int first = op.get(op.size()-1);
                op.add(2*first);
            }
            else if(stack.peek().equals("C"))
            {
                op.remove(op.size()-1);
            }
            else{
                op.add(Integer.valueOf(stack.peek()));
            }
            stack.pop();
        }
        int sum=0;
        for(int i=0;i<op.size();i++)
        {
            sum=sum+op.get(i);
        }
        return sum;
    }
}