class Solution {
    public int totalNQueens(int n) {
        int result[] = new int[1];
        char[][] board = new char[n][n];
        for(char row[]: board) Arrays.fill(row,'.');
        backtrack(n,0,board,result);
        return result[0];
    }
    private void backtrack(int n, int row, char board[][], int result[])
    {
        if(row == n)
        {
            result[0] += 1;
            return;
        }
        for(int col=0;col<n;col++)
        {
            if(isSafe(row,col,board,n))
            {
                board[row][col] = 'Q';
                backtrack(n,row+1,board,result);
                board[row][col] = '.';
            }
        }
    }
    private boolean isSafe(int row, int col, char board[][], int n)
    {
        for(int i=0;i<row;i++) if(board[i][col] =='Q') return false;
        for(int i=row-1,j=col-1;i>=0 && j>=0; i--,j--) if(board[i][j] =='Q') return false;
        for(int i=row-1,j=col+1;i>=0 && j<n; i--,j++) if(board[i][j] =='Q') return false;
        return true;
    }
}