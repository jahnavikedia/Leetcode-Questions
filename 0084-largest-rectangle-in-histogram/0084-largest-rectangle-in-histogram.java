class Solution {
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
       Stack<int[]> stack = new Stack<>();
       int maxArea = 0;
       for(int i=0;i<n;i++)
       {
        int start=i;
        while(!stack.isEmpty() && stack.peek()[1]>heights[i]) {
            int top[] = stack.pop();
            int height = top[1];
            int barStart = top[0];
            maxArea = Math.max(maxArea,height * (i-barStart));
            start=barStart;
        }

        stack.push(new int[]{start,heights[i]});
        
       } 
       while(!stack.isEmpty())
       {
        int top[] = stack.pop();
        int height = top[1];
        int barStart = top[0];
        maxArea = Math.max(maxArea, height*(n-barStart));
       }
       return maxArea;
    }
}