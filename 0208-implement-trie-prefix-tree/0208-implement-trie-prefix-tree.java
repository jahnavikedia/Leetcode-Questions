class Trie {

    class TrieNode{
        TrieNode children[] = new TrieNode[26];
        boolean isEndOfWord = false;
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
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
        TrieNode curr = root;
        for(char ch : word.toCharArray())
        {
            int idx = ch-'a';
            if(curr.children[idx]==null) return false;
            curr = curr.children[idx];
        }
        return curr.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch:prefix.toCharArray())
        {
            int idx = ch-'a';
            if(curr.children[idx]==null) return false;
            curr = curr.children[idx];
        }
        return true;
    }
}
