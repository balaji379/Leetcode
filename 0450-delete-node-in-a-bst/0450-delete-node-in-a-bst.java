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

    public TreeNode removeNode(TreeNode node,int key){
        if (node == null)
           return null;
        
        if (node.val > key){
            node.left = removeNode(node.left,key);
        }else if (node.val < key) {
            node.right = removeNode(node.right,key);
        }else{
            if (node.left == null && node.right == null)
               return null;
            else if (node.left == null)
                return node.right;
            else if (node.right == null)
                 return node.left;
            else {
                node.val = getLastSuccessor(node.right);
                node.right = removeNode(node.right,node.val);
            }
        }
        return node;
    }

    public int getLastSuccessor(TreeNode node){
        if (node.left == null)
           return node.val;
        return getLastSuccessor(node.left);
    }
         
    public TreeNode deleteNode(TreeNode root, int key) {
         return removeNode(root,key);
    }
}