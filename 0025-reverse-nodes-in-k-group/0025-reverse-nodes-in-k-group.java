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
    public ListNode reverseKGroup(ListNode head, int k) {
      ListNode temp=head;
      ListNode prev=null;
      while(temp!=null){
        ListNode kthNode=getKthNode(temp,k);
        if(kthNode==null){
            if(prev!=null)prev.next=temp;
            break;
        }
        ListNode nxtNode=kthNode.next;
        kthNode.next=null;
        revList(temp);
        if(temp==head){
            head=kthNode;
        }else{
            prev.next=kthNode;
        }
        prev=temp;
        temp=nxtNode;

      } 
      return head; 
    }
    public ListNode getKthNode(ListNode temp,int k){
        k-=1;
        while(temp!=null && k>0){
            temp=temp.next;
            k--;
        }
        return temp;
    }
    public ListNode revList(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null){
            ListNode nxtNode=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nxtNode;
        }
        return prev;
    } 

    
}