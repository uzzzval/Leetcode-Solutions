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
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        if (head.next==null) return false;
        if (head.next==head) return true;
        
        Set newSet=new HashSet();
        boolean isCircular=false;
        while(head!=null){
            if(newSet.contains(head)){
              isCircular=true;
              break;
            }
            else{
                newSet.add(head);
            }   
            head=head.next;
        }
        return isCircular;
    }
}
