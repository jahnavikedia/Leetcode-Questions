class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int a : asteroids)
        {
            while(!stack.isEmpty() && a<0 && stack.peek() > 0)
            {
                int sum = a+stack.peek();
                if(sum<0) stack.pop();
                else if(sum>0) a=0;
                else
                {
                    a=0;
                    stack.pop();
                }
            }
            if(a!=0) stack.push(a);
        }
        int[] array = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            array[i] = stack.get(i); 
        }
        return array;

    }
}