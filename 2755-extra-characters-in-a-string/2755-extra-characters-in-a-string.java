public class TrieNode
{
    TrieNode children[] = new TrieNode[26];
    boolean isEnd = false;
}
class Solution {
    private TrieNode root = new TrieNode();
    public int minExtraChar(String s, String[] dictionary) {
        for(String word : dictionary)
        {
            insert(word);
        }
        int n = s.length();
        Integer[] dp = new Integer[n];
        return dfs(s,0,dp,n);
    }
    private void insert(String word)
    {
        TrieNode node = root;
        for(char ch: word.toCharArray())
        {
            int index = ch-'a';
            if(node.children[index] == null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEnd = true;
    }
    private int dfs(String s, int index, Integer dp[], int n)
    {
        if(index == n) return 0;
        if(dp[index]!=null) return dp[index];
        int res = 1 + dfs(s,index+1,dp,n);
        TrieNode node = root;
        for(int j=index;j<n;j++)
        {
            char ch = s.charAt(j);
            int in = ch-'a';
            if(node.children[in]==null) break;
            node = node.children[in];
            if(node.isEnd) res = Math.min(res,dfs(s,j+1,dp,n));  
        }
        return dp[index] = res;  
    } 
}