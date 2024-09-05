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
        public static ListNode reverse(ListNode node, ListNode head) {
        if (node == null)
            return head;
        int cur = node.val;
        ListNode temp = reverse(node.next, head);
        temp.val = cur;
        return temp.next;
    }
    public ListNode reverseList(ListNode head) {
        if(head!=null)
             reverse(head,head);
        return head;
    }
}