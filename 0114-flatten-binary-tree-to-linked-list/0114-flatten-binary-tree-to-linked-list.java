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
    public static void preorder( TreeNode node , ArrayList<TreeNode> tree , TreeNode last  ){

             if( node == null) 
                return ;
             tree.get(0).right = new TreeNode( node.val );
             tree.set( 0 , tree.get(0).right );
             preorder( node.left , tree , last );
             preorder( node.right , tree , last );
              
               

    } 
    public void flatten(TreeNode root) {
           TreeNode output = new TreeNode();
           if( root != null ){
           TreeNode right = root.right;
           TreeNode last = new TreeNode();
           ArrayList<TreeNode> tree = new ArrayList<>();
           tree.add( root );
           preorder( root.left , tree , last );
           System.out.println("the array list is :" + tree.get(0).val);
           preorder( right , tree , last );
           root.left = null;

           }
    }
}