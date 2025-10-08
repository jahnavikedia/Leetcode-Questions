class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int n = height.length;
        int i=0,j=n-1;
        while(i<j && i>=0 && j>=0 && i<n && j<n)
        {
            int water = Math.min(height[i],height[j]) * (j-i);
            max = Math.max(water,max);
            if(height[i]<=height[j]) i++;
            else j--;
        }
        return max;
    }
}