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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else if( root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left == null && root.right == null){
                return null;
            }
            else if(root.left!=null && root.right==null){
                return root.left;
            }else if(root.left == null && root.right!=null){
                return root.right;
            }else{
                int max = findMin(root.right);
                root.val = max;
                root.right = deleteNode(root.right,max);

            }
        }
        return root;
       
    }
    public int findMin(TreeNode root){
        TreeNode curr = root;
        while(curr.left!=null){
            curr = curr.left;
        }
        return curr.val;
    }
}