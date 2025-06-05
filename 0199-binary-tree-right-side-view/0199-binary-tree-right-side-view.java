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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        rightView(root, op, 0);
        return op;
    }
    public void rightView(TreeNode root, List<Integer> op, int level)
    {
        if(root == null) return;
        if(op.size() == level) op.add(root.val);
        rightView(root.right, op, level+1);
        rightView(root.left, op, level+1);
    }
}