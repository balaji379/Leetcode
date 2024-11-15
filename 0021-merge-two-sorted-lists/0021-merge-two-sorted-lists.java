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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null&&list2==null)
        return list1;
        else if(list1==null)
        return list2;
        else if(list2==null)
        return list1;
     ListNode q=new ListNode();
     ListNode head=q;
     merge(list1,list2,head);   
     return head;
    }
     static  void merge(ListNode temp1,ListNode temp2,ListNode addData ){
        while(temp1!=null&&temp2!=null){
        if(temp1.val<temp2.val){
            addData.val=temp1.val;
            temp1=temp1.next;
            if(temp1!=null){
            addData.next=new ListNode();
            addData=addData.next;}
        }
        else{
            addData.val=temp2.val;
            temp2=temp2.next;
            if(temp2!=null){
            addData.next=new ListNode();
            addData=addData.next;}
        }
    }
        if(temp1!=null){
            addData.next=temp1;
        }
        if(temp2!=null){
            addData.next=temp2;
        }
    }
}