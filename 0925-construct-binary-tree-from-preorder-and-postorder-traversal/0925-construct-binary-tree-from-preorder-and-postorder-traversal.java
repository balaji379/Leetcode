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
    public int preindex = 0,postindex = 0;
    public  TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[0]);
        preindex += 1;
        construct(preorder, postorder, root);
        // root.preorder(root);
        return root;
    }

    public  void construct(int[] preorder, int[] postorder, TreeNode node) {

        if (preindex >= preorder.length || postindex >= postorder.length)
             return;

        if (node.val == postorder[postindex]) {
            postindex += 1;
            return;
        }
        TreeNode left = new TreeNode(preorder[preindex]);
        node.left = left;
        preindex += 1;
        construct(preorder, postorder, node.left);
        if (node.val == postorder[postindex]){
            postindex += 1;
            return;
        }
        if (preindex < preorder.length && postorder.length > postindex) {
            TreeNode right = new TreeNode(preorder[preindex]);
            node.right = right;
            preindex += 1;
            construct(preorder, postorder, node.right);
        }
        postindex += 1;
    }
}
