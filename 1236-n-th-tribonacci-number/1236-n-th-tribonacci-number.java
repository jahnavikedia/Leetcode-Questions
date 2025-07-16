class Solution {
    public int tribonacci(int n) {
        int t[] = new int[n+1];
        Arrays.fill(t,-1);
        int ans = solve(t,n);
        return ans;
    }
    public int solve(int t[], int n)
    {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        if(t[n] != -1) return t[n];
        t[n] = solve(t,n-1)+solve(t,n-2)+solve(t,n-3);
        return t[n];
    }
}