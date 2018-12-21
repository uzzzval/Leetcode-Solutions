/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
    		return head;
    	}
        ListNode parent = new ListNode(0);
        parent.next = head;
        ListNode dummy = parent;
        System.out.println(parent);
         while (head != null) {
    		if (head.val == val) {
    			parent.next = head.next;
    		} else {
    			parent = parent.next;
    		}
    		head = head.next;
    	}
        return dummy.next;
    }
}

