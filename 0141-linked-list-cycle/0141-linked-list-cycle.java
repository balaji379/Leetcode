/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode small = head,fast = head;
        if (head == null)
            return false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            small = small.next;
            if (fast == small)
                return true;
        }
        return false;
    }
}