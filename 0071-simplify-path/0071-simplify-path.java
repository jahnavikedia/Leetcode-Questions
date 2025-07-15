class Solution {
    public String simplifyPath(String path) {
        String parts[] = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String part: parts)
        {
            if(part.equals("") || part.equals(".")) continue;
            else if(part.equals("..")) 
            {
                if(!stack.isEmpty()) stack.pop();
            }
            else stack.push(part);
        }
        StringBuilder sb = new StringBuilder();
        for(String dir : stack) sb.append("/").append(dir);
        if(sb.length()>0)return sb.toString(); 
        return "/";
    }
}