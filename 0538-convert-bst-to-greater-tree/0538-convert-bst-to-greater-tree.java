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
       public int getGreaterBST(TreeNode node , int totalSum){
        if (node == null)
             return totalSum;
        
        totalSum = getGreaterBST(node.right,totalSum);
        totalSum += node.val;
        node.val = totalSum;
        totalSum = getGreaterBST(node.left,totalSum);
        return totalSum;
       }

    public TreeNode convertBST(TreeNode root) {
        getGreaterBST(root , 0);
        return root;
    }
}