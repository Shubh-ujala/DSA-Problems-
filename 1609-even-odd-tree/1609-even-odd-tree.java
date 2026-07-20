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
    public boolean isEvenOddTree(TreeNode root) {
        boolean ans = false;
        Queue<TreeNode> q= new LinkedList<>();
        boolean isEven = true;
        q.add(root);
        
        while(!q.isEmpty()){
            int n = q.size();
            int prev;
            if(isEven){
                prev = Integer.MIN_VALUE;
            }else{
                prev = Integer.MAX_VALUE;
            }
            for(int i = 0 ; i<n ; i++){
                TreeNode curr = q.poll();
                if(isEven){
                    if(curr.val%2 == 0 || curr.val <= prev) return false;
                }else{
                    if(curr.val%2!= 0 || curr.val >= prev) return false;
                }

                prev = curr.val;
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            isEven = !isEven;
        }
        return true;
    }
}