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
    public ListNode reverseBetween(ListNode head, int l, int r) {
         ListNode left = null ,right = null,pre = null,temp = head;
         if (l == r)
            return head;
         System.out.println(temp.val);
         for (int i = 1; i <= r; i++){
            if (i == l){
                // System.out.println("left is true");
                // pre = temp;
                left = temp;
            }if (i == r){
                // System.out.println("right is true");
                right = temp;
            }
            if (left == null)
                pre = temp;
            temp = temp.next;
         }
         ListNode cur = left,last = right.next;
         ListNode previous = null,next = cur.next;
         int ll = l;
         while (l < r + 1){
             cur.next = previous;
             previous = cur;
             cur = next;
             if (next != null)
               next = next.next;
               l += 1;
         }
        if(ll == 1){
          left.next = last;
          return previous;
        }
        else {
            pre.next = previous;
            left.next = last;
        }
        return head;
    }
}