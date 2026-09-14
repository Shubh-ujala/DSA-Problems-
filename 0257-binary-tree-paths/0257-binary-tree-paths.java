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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        solve(root, "", res);
        return res;
    }

    public void solve(TreeNode root, String path, List<String> res) {
        if (root == null) return;

        if (path.length() == 0) {
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }

        if (root.left == null && root.right == null) {
            res.add(path);
            return;
        }

        solve(root.left, path, res);
        solve(root.right, path, res);
    }
}