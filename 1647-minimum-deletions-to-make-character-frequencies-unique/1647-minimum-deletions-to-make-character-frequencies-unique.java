class Solution {
    public int minDeletions(String s) {
        int fre[] = new int[26];
        for(char c:s.toCharArray())
        {
            fre[c-'a']++;
        }
        Set<Integer> used = new HashSet<>();
        int del = 0;
        for(int f: fre)
        {
            while(f>0 && used.contains(f))
            {
                f--;del++;
            }
            if(f>0) used.add(f);
        }
        return del;
    }
}