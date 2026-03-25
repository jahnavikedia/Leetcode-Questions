/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr == null) sb.append("N,");
            else
            {
                sb.append(curr.val).append(",");
                q.offer(curr.left);
                q.offer(curr.right);
            }
        }
        return sb.toString(); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) return null;
        String values[] = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int idx=1;
        while(!q.isEmpty() && idx<values.length)
        {
            TreeNode curr = q.poll();
            if(!values[idx].equals("N"))
            {
                curr.left = new TreeNode(Integer.parseInt(values[idx]));
                q.offer(curr.left);
            }
            idx++;
            if(!values[idx].equals("N"))
            {
                curr.right = new TreeNode(Integer.parseInt(values[idx]));
                q.offer(curr.right);
            }
            idx++;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));