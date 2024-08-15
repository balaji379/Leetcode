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
class BSTIterator {
      public  TreeNode root;
      LinkedList<Integer> nodes ;
    public BSTIterator(TreeNode root) {
        this.root = root;
        nodes = new LinkedList<Integer>();
        postorder(root);
        System.out.println(nodes);
    }

     private  void postorder(TreeNode node) {
         if(node==null) 
          return ;
         postorder(node.left);
         nodes.add(node.val);
         postorder(node.right);
     }

    public int next() {
         return nodes.poll();
    }
    
    public boolean hasNext() {
        return nodes.isEmpty()==true?false:true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */