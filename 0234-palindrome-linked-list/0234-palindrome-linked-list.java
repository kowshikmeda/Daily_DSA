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
    public boolean isPalindrome(ListNode head) {
        Stack <ListNode> st=new Stack();
        ListNode temp=head;
        while(temp!=null){
            st.add(temp);
            temp=temp.next;
        }
        while(!st.isEmpty()){
            ListNode top=st.pop();
            if(top.val!=head.val){
                return false;
            }
            head=head.next;
        }
        return true;
    }
}