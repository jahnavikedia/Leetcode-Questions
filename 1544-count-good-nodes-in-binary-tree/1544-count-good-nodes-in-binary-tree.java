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
    public int goodNodes(TreeNode root) {
        int max = root.val;
        int count[] = new int[1];
        findNumber(root, max,count);
        return count[0];
    }
    int findNumber(TreeNode root, int max, int count[])
    {
        if(root == null) return 0;
        if(root.val >= max) 
        {
            max = root.val;
            count[0] = count[0]+1;
        }
        findNumber(root.left,max,count);
        findNumber(root.right,max,count);
        return count[0];
    }
}