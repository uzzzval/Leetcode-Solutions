/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class AddTwoNumbersLinkList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode returnNode = new ListNode(0);
        ListNode pointerNode = new ListNode(0);
        pointerNode = returnNode;
        while(l1!=null || l2!=null){
            ListNode localNode = new ListNode(0); 
            int localSum = carry;
            int effectiveNum = 0;
            
            if(l1!=null){
                localSum = localSum + l1.val;
                l1=l1.next;
            }
            
            if(l2!=null){
                localSum = localSum + l2.val;
                l2=l2.next;
            }
            
            if(localSum>=10){
                effectiveNum = localSum - 10;
                carry = 1;
            }else{
                effectiveNum = localSum;
                carry = 0;
            }
            
            localNode.val = effectiveNum;
            localNode.next = null;
            returnNode.next = localNode;
            returnNode = localNode;
            
        }
        
         if(carry!=0){
            ListNode localNode = new ListNode(0); 
            localNode.val = carry;
            localNode.next = null;
            returnNode.next = localNode;
            returnNode = localNode;
         }
        return pointerNode.next;
    }
}
