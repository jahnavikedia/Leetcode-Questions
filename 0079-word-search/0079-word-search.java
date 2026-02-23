class Solution {
    int dir[][] = {{-1,0},{1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(backtrack(board,word, m, n, 0, i, j)) return true;
            }
        }
        return false;
    }

    public boolean backtrack(char board[][], String word, int m, int n, int idx, int i, int j)
    {
        if(word.length() == idx) return true;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]!=word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        for(int d[] : dir)
        {
            int x = d[0]+i;
            int y = d[1]+j;
            if(backtrack(board, word, m, n, idx+1, x,y) == true) return true;
        }
        board[i][j] = temp;
        return false;
    }
}