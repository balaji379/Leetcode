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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null)
            return null;
        int lh = height(root.left);
        int rh = height(root.right);

        if (lh == rh)
           return root;
        else if (lh > rh)
          return  lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
        
    }
    public int height(TreeNode node){
        if (node == null)
          return 0;

        return 1 + Math.max(height(node.left),height(node.right));
    }
}