/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveDuplicatesFromSortedLinkList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        if(head.next==null) return head;
        ListNode current=head;
        while(current!=null){
        if(current.next!=null){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }else{
                current=current.next;
               }  
              }else{
            break;
          }  
         }
        return head;
    }
}
