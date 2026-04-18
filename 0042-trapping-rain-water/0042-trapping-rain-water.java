class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft = 0, maxRight = 0;
        int i = 0, j = n - 1;
        int water = 0;
        while (i < j) {
            if (height[i] <= height[j]) {
                maxLeft = Math.max(maxLeft, height[i]);
                water  += maxLeft - height[i];
                i++;
            } else {
                maxRight = Math.max(maxRight, height[j]);
                water   += maxRight - height[j];
                j--;
            }
        }
        return water;
    }
}

