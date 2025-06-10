/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
         ListNode pre = node,temp = node.next;
         while (temp != null)   {
            int val = temp.val;
            temp.val = pre.val;
            pre.val = val;
            pre = temp;
            temp = temp.next;
         }
         temp = node;
         while (temp.next.next != null){
            temp = temp.next;
         }
         temp.next = null;
    }
}