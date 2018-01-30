/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null && headB==null) return null;
        if(headA==null || headB==null) return null;
        
        List list1=new ArrayList();
        
        ListNode currentA=headA;
        ListNode currentB=headB;
        ListNode intersect=null;
        
        while(currentA!=null){
            list1.add(currentA);
            currentA=currentA.next;
        }
        
        while(currentB!=null){
            if(list1.contains(currentB)){
               intersect=currentB; 
                break;
            }else{
                currentB=currentB.next;
            } 
        }
        
        return  intersect;
    }
}
