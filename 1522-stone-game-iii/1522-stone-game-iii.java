class Solution {
    public String stoneGameIII(int[] stone) {
        int n = stone.length;
        int dp[] = new int[n+1];
        for(int i=n-1;i>=0;i--)
        {
            int takeOne=Integer.MIN_VALUE;
            int takeTwo=Integer.MIN_VALUE;
            int takeThree=Integer.MIN_VALUE;
            //one stone
            takeOne = stone[i] - dp[i+1];
            //two stones
            if(i+1<n)
            {
                int sum = stone[i] + stone[i+1];
                takeTwo = sum - dp[i+2];
            }
            //3 stones
            if(i+2<n)
            {
                int sum = stone[i]+stone[i+1]+stone[i+2];
                takeThree = sum - dp[i+3];
            }
            dp[i] = Math.max(takeOne,Math.max(takeTwo,takeThree));
        }
        if(dp[0]>0) return "Alice";
        else if(dp[0]<0) return "Bob";
        return "Tie";
    }
}