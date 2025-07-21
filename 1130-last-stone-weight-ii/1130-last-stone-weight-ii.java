class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int stone:stones) sum+=stone;
        int target = sum/2;
        boolean t[] = new boolean[target+1];
        t[0] = true;
        for(int stone:stones) 
        {
            for(int j=target;j>=stone;j--)
            {
                 t[j] = t[j] || t[j-stone];
            }
        }
        for(int i=target;i>=0;i--)
        {
            if(t[i]) return sum-2*i;
        }
        return 0;
    }
}