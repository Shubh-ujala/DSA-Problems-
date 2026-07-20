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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>(); 
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        boolean  isLeftToRight = true;
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> a = new ArrayList<>();

            for(int i = 0 ; i<n ; i++){
                TreeNode curr = q.poll();
                a.add(curr.val);
                if(curr.left!=null) q.offer(curr.left);
                if(curr.right!=null) q.offer(curr.right);
            }
            if(isLeftToRight){
                ans.add(a);
                isLeftToRight = !isLeftToRight;
            }else{
                Collections.reverse(a);
                ans.add(a);
                isLeftToRight = !isLeftToRight;
            }
        }

        return ans;
    }

}