class Solution {
    public boolean isHappy(int n) {
        int slow=n; int fast =n;
        do
        {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        }while(slow!=fast);

        return slow==1;
    }
    private int sumOfSquares(int n)
    {
        int sum=0;
        while(n!=0)
        {
            int d = n%10;
            n=n/10;
            sum+=(d*d);
        }
        return sum;
    }
}