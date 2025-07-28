class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordLists) {
        Set<String> wordList = new HashSet<>(wordLists);
        if(!wordList.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        int level=1;
        visited.add(beginWord);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                String word = q.poll();
                char arr[] = word.toCharArray();
                for(int j=0;j<arr.length;j++)
                {
                    char original = arr[j];
                    for(char c = 'a';c<='z';c++)
                    {
                        if(c==original) continue;
                        arr[j] = c;
                        String newWord = new String(arr);
                        if(newWord.equals(endWord)) return level+1;
                        if(wordList.contains(newWord) && !visited.contains(newWord))
                        {
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }
                    arr[j] = original;
                } 
            }
            level++;
        }
        return 0;
    }
}