class Solution {
    public int mySqrt(int x) {
        int start=0;
        int end=x/2;
        if(x==0)return 0;
        if(x==1)return 1;
        int res=0;
        while(start<=end)
        {
            int mid = start + ((end-start)/2);
            long square = (long) mid * mid;
            if(square == x)
            {
                return mid;
            }
            else if(square < x)
            {
                res = mid;
                start = mid+1;
            }
            else if(square > x)
            {
                end = mid-1;
            }
        }
        return res;
    }
}