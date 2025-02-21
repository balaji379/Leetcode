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
class FindElements {
    private TreeNode root;
    private Set<Integer> container;
    public FindElements(TreeNode root) {
        this.root = root;
        container = new HashSet<>();
        container.add(0);
        if (this.root != null){
            root.val = 0;
            solve(this.root,false,false,0);
            // display(root);
        }
    }
    
    public boolean find(int target) {
          return container.contains(target);
    }

    public void solve(TreeNode node,boolean left,boolean right,int headval){
        if(node == null)
            return ;
        if(left){
               node.val = (2 * headval) + 1;
               container.add(node.val);
        }
        if (right){
              
               node.val = (2 * headval) + 2;
               container.add(node.val);
        }
        solve(node.left,true,false,node.val);
        solve(node.right,false,true,node.val);
    }

    // public boolean findTarget(TreeNode node,int target){
    //     if (node == null)
    //         return false;
        
    //     if(node.val == target)
    //          return true;

    //      return  (findTarget(node.right,target) || findTarget(node.left,target));  
        
    // }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */