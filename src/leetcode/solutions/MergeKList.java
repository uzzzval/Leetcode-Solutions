package leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MergeKList {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();
        ListNode returnNode = null;
        ListNode pointerNode = returnNode;
        for(int i=0;i<lists.length;i++){
            ListNode listNode = lists[i];
            while(listNode!=null){
                list.add(listNode.val);
                listNode=listNode.next;
            }
        }
        Collections.sort(list);
        
        for(int item:list){
            ListNode local = new ListNode(item);
            if(returnNode==null){
              returnNode = local; 
              pointerNode = returnNode;
            }  
            else{
               returnNode.next = local;
               returnNode = returnNode.next;      
            }             
        }
        return pointerNode;
    }
}
