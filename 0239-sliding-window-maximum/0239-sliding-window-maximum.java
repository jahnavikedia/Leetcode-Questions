class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0,j=0,max=0;
        int op[] = new int[nums.length-k+1];
        Deque<Integer> q = new LinkedList<>();
        while(j<nums.length)
        {
            while(!q.isEmpty() && q.peekLast()<nums[j])
            {
                q.removeLast();
            }
            q.add(nums[j]);
            if(j-i+1 == k)
            {
                op[i] = q.peek();
                if(nums[i] == q.peek())
                {
                    q.removeFirst();
                }
                i++;
            }
            j++;
        }
        return op;
    }
}