class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if(numRows==1 || numRows>n) return s;
        StringBuilder rows[] = new StringBuilder[numRows];
        for(int i=0;i<numRows;i++) rows[i] = new StringBuilder();
        boolean goingDown = false;
        int currRow = 0;
        for(char c: s.toCharArray())
        {
            rows[currRow].append(c);
            if(currRow == 0 || currRow==numRows-1) goingDown = !goingDown;
            currRow += goingDown? 1: -1;
        }
        StringBuilder result = new StringBuilder();
        for(StringBuilder row : rows)
        {
            result.append(row);
        }
        return result.toString();
    }
}