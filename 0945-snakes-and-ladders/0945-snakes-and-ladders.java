class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        reverseBoard(board);
        boolean visited[] = new boolean[n*n+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,0});
        while(!queue.isEmpty())
        {
            int curr[] = queue.poll();
            int square = curr[0];
            int moves = curr[1];
            if(square == n*n) return moves;
            for(int i=1;i<=6 && square+i <= n*n; i++)
            {
                int nextSquare = i+square;
                int[] coords = getCoordinates(nextSquare,n);
                int row = coords[0];
                int col = coords[1];
                if(board[row][col] != -1)
                {
                    nextSquare = board[row][col];
                }
                if(!visited[nextSquare])
                {
                    visited[nextSquare] = true;
                    queue.offer(new int[]{nextSquare,moves+1});
                }
            }
        }
        return -1;
    }

    public int[] getCoordinates(int square, int n)
    {
        int row = (square-1)/n;
        int col = (square-1)%n;
        if(row%2==1)
        {
            col=n-1-col;
        }
        return new int[]{row,col};
    }
    public void reverseBoard(int[][] board) {
    int top = 0, bottom = board.length - 1;
    while (top < bottom) {
        int[] temp = board[top];
        board[top] = board[bottom];
        board[bottom] = temp;
        top++;
        bottom--;
    }
}

}