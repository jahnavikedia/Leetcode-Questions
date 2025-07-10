class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s,0,result,new ArrayList<String>());
        return result;
    }
    private void backtrack(String s, int start, List<List<String>> result, ArrayList<String> path)
    {
        if(start==s.length())
        {
            result.add(new ArrayList<>(path));
            return;
        }
        for(int end=start;end<s.length();end++)
        {
            String substr = s.substring(start,end+1);
            if(isPalindrome(substr))
            {
                path.add(substr);
                backtrack(s,end+1,result,path);
                path.remove(path.size()-1);
            }
        }
    }
    private boolean isPalindrome(String s)
    {
        int i=0,j=s.length()-1;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        } 
        return true;
    }
}