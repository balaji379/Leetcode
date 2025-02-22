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
    public int index = 0;
    public TreeNode recoverFromPreorder(String traversal) {
        int val = getNum(traversal);
        TreeNode root = new TreeNode(val);
        BuildTree(root,traversal,0);
        return root;
    }

    public int BuildTree(TreeNode node, String s, int d) {
        if (index > s.length())
              return -1;
        if (index == s.length()){
            return -1;
        }
        int start = index;
        int dep = getDepth(s);
        if (d + 1 == dep){
            if (node.left == null){
                int val = getNum(s);
                TreeNode newnode = new TreeNode(val);
                node.left = newnode;
               dep =  BuildTree(node.left,s,d + 1);
            }
            if (d + 1 == dep){
                 int val = getNum(s);
                TreeNode newnode = new TreeNode(val);
                node.right = newnode;
                node.right = newnode;
                dep = BuildTree(node.right,s,d + 1);
            }
        }else if (d + 1  > dep){
            return dep;
        }
        return dep;
    }

    public int getDepth(String s) {
        int count = 0;
        while (index < s.length() && s.charAt(index) == '-') {
            count += 1;
            index += 1;
        }
        return count;
    }
    public int getNum(String s ){
        int end = index,start = index;
        while (end < s.length() && s.charAt(end) != '-'){
            end += 1;
            index += 1;
        }
        return Integer.parseInt(s.substring(start,end));
    }
}