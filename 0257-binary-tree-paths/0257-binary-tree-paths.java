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
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        solve(root,"");
        return list;
    }
    public void solve(TreeNode node,String s){
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            list.add(s + String.valueOf(node.val));
        }
        solve(node.left,s + String.valueOf(node.val) + "->");
        solve(node.right,s + String.valueOf(node.val) + "->");
    }
}