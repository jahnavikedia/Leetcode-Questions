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
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0;i<inOrder.length;i++)
            inMap.put(inOrder[i],i);
        TreeNode root = buildTreeHelper(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1, inMap);
        return root;
    }
    public TreeNode buildTreeHelper(int preOrder[], int preStart, int preEnd, int inOrder[], int inStart, int inEnd, Map<Integer,Integer> inMap)
    {
        if(preStart>preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = inMap.get(root.val);
        int left = inRoot - inStart;
        root.left = buildTreeHelper(preOrder, preStart+1, preStart + left, inOrder, inStart, inRoot -1, inMap);
        root.right = buildTreeHelper(preOrder, preStart+left+1, preEnd, inOrder, inRoot+1, inEnd, inMap);
        return root;
    }
}