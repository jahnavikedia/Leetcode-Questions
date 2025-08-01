class Solution {
    public boolean isAlienSorted(String[] words, String o) {
        Map<Character,Integer> map = new HashMap<>();
        int n = words.length;
        for(int i=0;i<26;i++)
        {
            map.put(o.charAt(i),i);
        }
        for(int i=0;i<n-1;i++)
        {
            String w1 = words[i];
            String w2 = words[i+1];
            boolean found = false;
            for(int j=0;j<Math.min(w1.length(),w2.length());j++)
            {
                int c1 = map.get(w1.charAt(j));
                int c2 = map.get(w2.charAt(j));
                if(c1<c2)
                {
                    found=true;
                    break;
                } 
                if(c1>c2) return false;
                
            }
            if(!found && w1.length()>w2.length()) return false;
        }
        return true;
    }
}