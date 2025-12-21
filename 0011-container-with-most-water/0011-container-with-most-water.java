class Solution {
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int n = height.length;
        int l=0, r = n-1;
        while(l<r)
        {
            int area = Math.min(height[l],height[r]) * (r-l);
            max = Math.max(area,max);
            if(height[l]<=height[r]) l++;
            else r--;
        }
        return max;
    }
}