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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        solve(root,0);
        return ans;
    }

    public void solve(TreeNode root, int l){
        if(root == null) return;

        if(l == ans.size()) ans.add(root.val);
        solve(root.right,l+1);
        solve(root.left,l+1);
    }
}