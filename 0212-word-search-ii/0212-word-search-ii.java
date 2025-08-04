class TrieNode
{
    TrieNode[] children= new TrieNode[26];
    boolean isEnd=false;
    String word="";
}
class Solution {
    private TrieNode root = new TrieNode();
    int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        for(String word : words)
        {
            insert(word);
        }
        TrieNode node = root;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int index = board[i][j]-'a';
                if(node.children[index]!=null) backtrack(board,i,j,m,n,res,node.children[index]);
            }
        }
        return res;
    }
    private void backtrack(char[][] board, int i, int j, int m, int n, List<String> res, TrieNode node)
    {
        if(node.isEnd == true)
        {
            res.add(node.word);
            node.isEnd = false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        for(int dir[] : dirs)
        {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x<0 || y<0 || x>=m || y>=n || board[x][y]=='#') continue;
            char nextChar = board[x][y];
            int newIndex = nextChar-'a';
            if(node.children[newIndex]!=null)
            {
                backtrack(board,x,y,m,n,res,node.children[newIndex]);
            } 
        }
        board[i][j] = temp;

    }
    private void insert(String word)
    {
        TrieNode node = root;
        for(char ch: word.toCharArray())
        {
            int index = ch-'a';
            if(node.children[index]==null) node.children[index] = new TrieNode();
            node = node.children[index];
        }
        node.isEnd = true;
        node.word = word;
        return;
    }

}