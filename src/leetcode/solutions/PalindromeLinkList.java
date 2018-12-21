package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class PalindromeLinkList {
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return true;
        List arrayList=new ArrayList();
        
        while(head!=null){
            arrayList.add(head.val);
            head=head.next;
        }
      
        int length=arrayList.size();
        int i=0;
        int j=length-1;
        boolean isPalindrome=true;
        while(i<j){
          if(Integer.parseInt(arrayList.get(i).toString())!=Integer.parseInt(arrayList.get(j).toString()))
              isPalindrome=false;
          i++;
          j--;
        }
        return isPalindrome;
    }
}
