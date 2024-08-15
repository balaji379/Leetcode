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
      TreeSet<Integer> nodes = new TreeSet<>();
    public BSTIterator(TreeNode root) {
        this.root = root;
        postorder(root);
        System.out.println(nodes);
    }

     private  void postorder(TreeNode node) {
         if(node==null) 
          return ;
         postorder(node.left);
         postorder(node.right);
         nodes.add(node.val);
     }

    public int next() {
         return nodes.pollFirst();
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