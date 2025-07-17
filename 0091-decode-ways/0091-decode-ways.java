class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int t[] = new int[n+1];
        t[0] = 1;
        t[1] = s.charAt(0)=='0'?0:1;
        for(int i=2;i<=n;i++)
        {
            int one = Integer.valueOf(s.substring(i-1,i));
            int two = Integer.valueOf(s.substring(i-2,i));
            if(one != 0) t[i] += t[i-1];
            if(two >=10 && two<=26) t[i] += t[i-2]; 
        }
        return t[n];

    }
}