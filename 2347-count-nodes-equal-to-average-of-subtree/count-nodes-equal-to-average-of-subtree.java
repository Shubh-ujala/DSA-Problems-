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
    public int averageOfSubtree(TreeNode root) {
        if( root == null) return 0;

        int sum = CalculateSum(root);
        int count = CalculateNodes(root);
        int avg = sum / count;

        int left = averageOfSubtree(root.left);
        int right = averageOfSubtree(root.right);

        return (root.val == avg ? 1 : 0 )+ left + right;
    }
    private int CalculateSum(TreeNode root){
        if(root == null) return 0;

        int left = CalculateSum(root.left);
        int right = CalculateSum(root.right);

        return root.val + left + right;
    }
    private int CalculateNodes(TreeNode root){
        if(root == null) return 0;

        int left = CalculateNodes(root.left);
        int right = CalculateNodes(root.right);

        return 1 + left + right;
    }
}