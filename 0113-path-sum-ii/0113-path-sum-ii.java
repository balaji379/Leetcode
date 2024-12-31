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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
             int pathsum = 0;
             List<Integer> list =new LinkedList<>();
             List<List<Integer>> answer = new ArrayList<>();
             formPathSum(root,pathsum,targetSum,list,answer);
             return answer;
    }

    public void formPathSum (TreeNode node,int pathsum, int target, List<Integer> list, List<List<Integer>> answer){
         if (node != null && node.left == null && node.right == null) {
              if (target == node.val + pathsum){
                list.add(node.val);
                List<Integer> temp = new ArrayList<>(list);
                answer.add(temp);
                list.removeLast();
              }
            return;
         }else if (node == null )
             return;

         pathsum += node.val;
         list.add(node.val);
         formPathSum(node.left,pathsum,target,list,answer);
         formPathSum(node.right,pathsum,target,list,answer);
         if (!list.isEmpty())
            pathsum -= list.removeLast();
    }
}