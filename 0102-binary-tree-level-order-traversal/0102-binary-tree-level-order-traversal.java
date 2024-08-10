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
    public List<List<Integer>> levelOrder(TreeNode root) {

             Queue<TreeNode> queue  = new LinkedList<>();
             List<List<Integer>> answer = new ArrayList<>();
             queue.add(root);
             while(!queue.isEmpty()&&root!=null){
                int len = queue.size() , itr =0 ;
                List<Integer> list = new ArrayList<>();
                while(itr<len && !queue.isEmpty()){
                    TreeNode left = queue.peek().left;
                    TreeNode right = queue.peek().right ;
                    list.add(queue.remove().val);
                    if(left!=null) queue.add(left);
                    if(right!=null) queue.add(right);
                    itr+=1;
                }
                   answer.add(list);
             }
           return answer;
    }
}