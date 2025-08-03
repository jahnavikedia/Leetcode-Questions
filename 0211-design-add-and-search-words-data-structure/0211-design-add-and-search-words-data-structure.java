class TrieNode
{
    TrieNode children[] = new TrieNode[26];
    boolean isEnd = false;
}
class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray())
        {
            int index = ch-'a';
            if(node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
       return dfs(0,word,root);
    }

    private boolean dfs(int index, String word, TrieNode node)
    {
        if(index == word.length()) return node.isEnd;
        char ch = word.charAt(index);
        if(ch=='.')
        {
            for(TrieNode t : node.children)
            {
                if(t!=null && dfs(index+1,word,t))
                {
                    return true;
                }
            }
            return false;
        }
        else
        {
            int in = ch - 'a';
            if(node.children[in]==null) return false;
            return dfs(index+1,word,node.children[in]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */