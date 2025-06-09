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
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> res = new ArrayList<>();
        solve(root,k,res);
        return res.get(res.size()-1);
    }
    public void solve(TreeNode root, int k, List<Integer> res)
    {
        if(root==null) return;
        solve(root.left, k, res);
        if(res.size() == k) return;
        res.add(root.val);
        solve(root.right,k,res);
    }
}