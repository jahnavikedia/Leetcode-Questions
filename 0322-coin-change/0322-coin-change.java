class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int INF = amount+1;
        int t[] = new int[INF];
        Arrays.fill(t,INF);
        t[0] = 0;
        for(int i = 1;i<=amount;i++)
        {
            for(int coin: coins) 
            {
                if(coin<=i && t[i-coin]!=INF)
                {
                    t[i] = Math.min(t[i],1+t[i-coin]);
                }
            }
        }
        if(t[amount]>amount) return -1; return t[amount];
    }
}