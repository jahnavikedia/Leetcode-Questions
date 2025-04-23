class Solution {
    public int maxArea(int[] height) {
         int i=0,j=height.length-1;
         int max=0;
         while(i<j && i>=0 && j>=0 && i<height.length && j<height.length)
         {
            int area = Math.min(height[i],height[j]) * (j-i);
            System.out.println(area);
            max = Math.max(area,max);
            System.out.println(max);
            if(height[i]<=height[j]) i++;
            else j--;
         }
         return max;
    }
}