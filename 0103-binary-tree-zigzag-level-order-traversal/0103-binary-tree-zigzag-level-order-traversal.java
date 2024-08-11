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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        boolean leftflag = true ,rightflag = false ;
        List<List<Integer>> output  =  new ArrayList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        if(root==null ) return output;
        while(!nodes.isEmpty()){
            int itr = 0 , len =nodes.size()  ,rightind = len ;
            List<Integer> list = new LinkedList<>();
            while(itr<len && !nodes.isEmpty()){
                if(leftflag){
                    TreeNode left = nodes.peek().left,
                    right = nodes.peek().right;
                    list.addFirst(nodes.poll().val);
                    if(right!=null)
                           nodes.add(right);
                    if(left!=null)
                           nodes.add(left);
                }
                if(rightflag){
                       TreeNode left = nodes.peek().left,
                    right = nodes.peek().right;
                    list.add(nodes.poll().val);
                    if(right!=null)
                           nodes.add(right);
                    if(left!=null)
                           nodes.add(left);
                }
                itr+=1;
            }
            if(leftflag) { leftflag=false; rightflag=true ; }
            else{ rightflag = false; leftflag=true; }
            output.add(list);
        }

      return output;
    }
}