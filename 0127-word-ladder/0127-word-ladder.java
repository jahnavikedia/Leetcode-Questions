class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int levels =1;
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String word = q.poll();
                char chars[] = word.toCharArray();
                for(int j=0;j<chars.length;j++)
                {
                    char original = chars[j];
                    for(char c = 'a';c<='z';c++)
                    {
                        chars[j] = c;
                        String newWord = new String(chars);
                        if(newWord.equals(endWord)) return levels+1;
                        if(set.contains(newWord)) {
                            set.remove(newWord);
                            q.offer(newWord);
                        }
                    }
                    chars[j] = original;
                }
            }
            levels++;
        }
        return 0;
    }
}