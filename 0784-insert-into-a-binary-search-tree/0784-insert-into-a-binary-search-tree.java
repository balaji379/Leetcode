
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

    public TreeNode insertValue(TreeNode node , int newvalue){
        if (node == null)
           return new TreeNode(newvalue);
        
        if (node.val < newvalue)
           node.right = insertValue(node.right, newvalue);

        else if (node.val > newvalue)
            node.left = insertValue(node.left, newvalue);

        return  node;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        root = insertValue(root , val);
        return root;
    }
}