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
    public static  void findKsmallElement (TreeNode root , int[] arr,int k){
        if(root == null )
          return ;
        if(arr[k]!=k){
             findKsmallElement(root.left,arr,k);
             if(arr[k]!=k){
             arr[arr[k]] = root.val;
             arr[k] +=1 ;
             }
             findKsmallElement(root.right,arr,k);
        }
    } 
    public int kthSmallest(TreeNode root, int k) {
            int[] arr = new int[k+1];
            findKsmallElement(root,arr,k);
            return arr[k-1];
    }
}