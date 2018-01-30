/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ReverseLinkList {
    public ListNode reverseList(ListNode head){
        if(head == null) return head;
        ListNode current=head;
        ListNode prev=null;
        ListNode next;
        while(current!=null){
          next=current.next;
          current.next=prev;
          prev=current;
          current=next;
        }
        head=prev;
        return head;
    }
}
