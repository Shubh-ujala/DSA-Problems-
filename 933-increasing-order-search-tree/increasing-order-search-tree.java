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
    TreeNode res = new TreeNode(0);
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = res;
        inorder(root);

        return head.right;
    }
    private void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        res.right = root;
        root.left = null;
        res = res.right;
        inorder(root.right);
    }
}