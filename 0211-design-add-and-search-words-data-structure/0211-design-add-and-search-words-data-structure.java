class WordDictionary {
    class TrieNode{
        TrieNode children[] = new TrieNode[26];
        boolean isEndOfWord = false;

    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray())
        {
            int idx = ch-'a';
            if(curr.children[idx]==null) curr.children[idx] = new TrieNode();
            curr = curr.children[idx];
        }
        curr.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int idx, TrieNode node)
    {
        if(idx == word.length()) return node.isEndOfWord;
        char c = word.charAt(idx);
        if(c=='.')
        {
            for(TrieNode child : node.children)
            {
                if(child!=null && dfs(word, idx+1, child)) return true; 
            }
            return false;
        }
        else
        {
            int i = c-'a';
            if(node.children[i]==null) return false;
            return dfs(word, idx+1,node.children[i]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */