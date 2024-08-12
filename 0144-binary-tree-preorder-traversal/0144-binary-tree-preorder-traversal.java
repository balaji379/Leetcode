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
    public void orderTraversal(TreeNode node,List<Integer> nodes){
        if(node == null)
            return ;
        nodes.add(node.val);
        orderTraversal(node.left,nodes);
        orderTraversal(node.right,nodes);

    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        orderTraversal(root,nodes);
        return nodes;
    }
}