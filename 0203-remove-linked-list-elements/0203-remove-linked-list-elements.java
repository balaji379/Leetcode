/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
            ListNode pre;
            ListNode temp;
      
         if( head != null ) {
             pre = head;
             temp = head.next;

            while( temp != null ){
                if( temp.val == val ){
                     pre.next = temp.next;
                     temp = pre.next;
                }else{
                pre = temp;
                temp = temp.next;
                }
            }
            if( head != null )
               if( head.val == val )
                  head = head.next;
         }
         return head;
    }
}