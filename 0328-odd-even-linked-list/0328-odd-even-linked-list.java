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
    public ListNode oddEvenList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp);
            temp = temp.next;
        }
        ListNode ans = new ListNode();
        ListNode headOfAns = ans;
        for(int i = 0; i < list.size(); i++){
            if((i&1) == 0) {
                temp = list.get(i);
                temp.next = null;
                ans.next = temp;
                ans = ans.next;
            }
        }
        for(int i = 0; i < list.size(); i++){
            if((i&1) == 1){
                temp = list.get(i);
                temp.next = null;
                ans.next = temp;
                ans = ans.next;
            }
        }
        return headOfAns.next;
    }
}