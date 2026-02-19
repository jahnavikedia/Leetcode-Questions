class Solution {
    public int[] nextGreaterElements(int[] nums) {
         Stack<Integer> stack = new Stack<>();
         int n = nums.length;
         int op[] = new int[n];
         for(int i=2*n-1;i>=0;i--)
         {
            int ind = i%n;
            if(stack.isEmpty()) op[ind] = -1;
            else if(i<n && stack.peek()>nums[ind]) op[i] = op[ind]=stack.peek();
            else
            {
                while(!stack.isEmpty() && stack.peek()<=nums[ind]) stack.pop();
                if(i<n)
                {
                    if(stack.isEmpty()) op[ind] = -1; 
                    else op[ind] = stack.peek();
                }  
            }
            stack.push(nums[ind]);
         }
         return op;
    }
}