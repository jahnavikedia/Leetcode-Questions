class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> row[] = new HashSet[9];
        Set<Character> col[] = new HashSet[9];
        Set<Character> box[] = new HashSet[9];
        for(int i=0;i<9;i++)
        {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            box[i] = new HashSet<>();
        }
        for(int r=0;r<9;r++)
        {
            for(int c=0;c<9;c++)
            {
                char num = board[r][c];
                if(num =='.') continue;
                int boxidx = (r/3)*3 + (c/3);
                if(row[r].contains(num) || col[c].contains(num) || box[boxidx].contains(num)) return false;
                row[r].add(num);
                col[c].add(num);
                box[boxidx].add(num);
            }
        }
        return true;
    }
}