class Solution {
    public int jump(int[] nums) {
        int l=0,r=0,jumps=0,n=nums.length;
        while(r<n-1)
        {
            int farthest = 0;
            for(int j=l;j<=r;j++)
            {
                farthest = Math.max(farthest,j+nums[j]);
            }
            l=r+1;
            r=farthest;
            jumps++;
        }
        return jumps;
    }
}