class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int board[] = new int[26];
        for(char ch: s.toCharArray()) board[ch - 'a']++;
        for(char ch : t.toCharArray()) board[ch-'a']--;
        for(int ch : board) if(ch!=0) return false;
        return true;
    }
}