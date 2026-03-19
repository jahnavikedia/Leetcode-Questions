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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       return build(preorder, inorder, 0, 0, inorder.length-1); 
    }
    public TreeNode build(int pre[], int in[], int preStart, int inStart, int inEnd)
    {
        if(preStart>pre.length-1 || inStart>inEnd) return null;
        TreeNode root = new TreeNode(pre[preStart]);
        int mid=0;
        for(int i=inStart;i<=inEnd;i++)
        {
            if(in[i]==root.val)
            {
                mid = i; break;
            }
        }
        int leftSize = mid-inStart;
        root.left = build(pre, in, preStart+1,inStart, mid-1);
        root.right = build(pre, in, preStart+1+leftSize, mid+1, inEnd);
        return root;
    }
}