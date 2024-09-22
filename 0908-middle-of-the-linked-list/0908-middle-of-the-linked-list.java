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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head ;
        int length = 0;
        while(temp!=null){
            length+=1;
            temp = temp.next;
        }
        int limit = length/2;
      
        length = 0;
        while(length <= limit && head!=null){
              if(limit == length){
                return head;
              }else{
              head = head.next;
              length += 1;
              }
        }
return null;
    }
}