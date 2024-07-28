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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result =new ListNode();
    ListNode head=result;
    int num1=0,num2=0,carry=0;int[] eachnum=new int[2];
    while(l1!=null||l2!=null){
     if(l1!=null){
         num1=l1.val;
         l1=l1.next;
     }
     if(l2!=null){
         num2=l2.val;
         l2=l2.next;
     }
     int sum=num1+num2;
     if(carry>0){
         sum=sum+carry; 
         carry=0;}
     if(sum>=10){
         for(int i=0;sum>=1;i++){
             eachnum[i]=sum%10;
             sum=sum/10;
         }
         carry=eachnum[1];
         sum=eachnum[0];
     }
     result.next=new ListNode(sum);
     result=result.next;
     sum=0;num1=0;num2=0;
    }
      if(carry!=0)
      result.next=new ListNode(carry);
      head=head.next;
      return head;
    }
}