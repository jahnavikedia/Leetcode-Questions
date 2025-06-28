class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col= board[0].length;
        boolean visited[][] = new boolean[row][col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(backtrack(board,word,0,i,j,visited)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row,int col, boolean visited[][])
    {
        if(index == word.length()) return true;
        if(row < 0 || row >=  board.length || col<0 || col>= board[0].length ||
            board[row][col]!=word.charAt(index) || visited[row][col]) return false;
        visited[row][col] = true;
        boolean found = backtrack(board,word, index+1, row+1,col,visited) || 
                        backtrack(board,word, index+1, row-1,col,visited) ||
                        backtrack(board,word, index+1, row,col+1,visited) ||
                        backtrack(board,word, index+1, row,col-1,visited);
        visited[row][col] = false;
        return found;
    }
}