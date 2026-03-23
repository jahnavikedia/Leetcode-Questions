class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int res[] = new int[n-k+1];
        int idx=0,i=0,j=0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        while(j<n)
        {
            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[j]) deque.pollLast();
            deque.addLast(j);
            if(i>deque.peekFirst()) deque.pollFirst();
            if(j-i+1 == k)
            {
                res[idx++] = nums[deque.peekFirst()];
                i++;
            }
            j++;
        }
        return res;
    }
}