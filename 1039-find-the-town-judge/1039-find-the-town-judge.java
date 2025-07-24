class Solution {
    public int findJudge(int n, int[][] trusts) {
        int in[] = new int[n+1];
        int out[] = new int[n+1];
        for(int trust[] : trusts)
        {
            int personTrusting = trust[0];
            int personTrusted = trust[1];
            out[personTrusting] += 1;
            in[personTrusted] +=1; 
        }
        for(int i=1;i<=n;i++)
        {
            if(in[i]==n-1 && out[i]==0) return i;
        }
        return -1;
    }
}