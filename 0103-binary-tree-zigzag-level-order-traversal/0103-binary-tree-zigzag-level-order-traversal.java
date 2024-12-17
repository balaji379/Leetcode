/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean evenOrder = false;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelsize = queue.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (evenOrder) {
                    level.addFirst(node.val);
                } else {
                    level.add(node.val);
                }
            }
            evenOrder = !evenOrder;
            list.add(level);
        }
        return list;
    }
}