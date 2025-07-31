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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)return head;
       ListNode temp=head;
       int len=0;
       while(temp!=null){
        temp=temp.next;
        len++;
       }
       if(k%len==0)return head;
       k=k%len;
       ListNode tail=head;
       while(tail.next!=null){
        tail=tail.next;
       }
       tail.next=head;
       for(int i=0;i<len-k-1;i++){
        head=head.next;
       }
       ListNode newHead=head.next;
       head.next=null;
       return newHead;


    }
}