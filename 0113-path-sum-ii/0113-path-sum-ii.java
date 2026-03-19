/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> op = new ArrayList<>();
        dfs(root,targetSum,op,new ArrayList<>());
        return op;
    }
    public void dfs(TreeNode root, int rem, List<List<Integer>> op, List<Integer> path)
    {
        if(root == null) return;
        path.add(root.val);
        if(root.left==null && root.right==null && rem==root.val) op.add(new ArrayList<>(path));
        dfs(root.left,rem-root.val,op,path);
        dfs(root.right,rem-root.val,op,path);
        path.remove(path.size()-1); 
    }
}