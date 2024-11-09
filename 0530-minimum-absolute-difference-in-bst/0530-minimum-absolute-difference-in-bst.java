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
    public int min(ArrayList<Integer> a,TreeNode node,int min){ 
        if(node==null)
        return min;
       
        min=min(a,node.left,min);
               a.add(node.val);
               int size=a.size();
               if(size>1){
                //    System.out.println("in condition:");
                   min=Math.min(min,Math.abs(a.get(size-2)-a.get(size-1)));
               }
               
        min=min(a,node.right,min);
        return min;
    }
    public int getMinimumDifference(TreeNode root) {
    return min(new ArrayList<Integer>(),root,Integer.MAX_VALUE);        
    }
}