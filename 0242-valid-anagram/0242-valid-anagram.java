class Solution {
    public boolean isAnagram(String s, String t) {
        int board[] = new int[26];
        for(char ch:s.toCharArray()) board[ch-'a']++;
        for(char ch: t.toCharArray()) board[ch-'a']--;
        for(int val:board) if(val!=0) return false;
        return true;
    }
}