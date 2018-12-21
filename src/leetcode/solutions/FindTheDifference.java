package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class FindTheDifference {
    public char findTheDifference(String s, String t) {
        List list1=new ArrayList();
        List list2=new ArrayList();
        char finalCh='\0';
        
        for(int i=0;i<s.length();i++){
            list1.add(s.charAt(i));
        }
        
        for(int i=0;i<t.length();i++){
            list2.add(t.charAt(i));
        }
        
        if(list1.size()>list2.size()){
            int run=list2.size();
            for(int i=0;i<run;i++){
               if(list1.contains(list2.get(i))){
                   list1.remove(list1.indexOf(list2.get(i)));
                   run--;
               } 
            }
            finalCh=(char)list1.get(0);
        }
        
        if(list2.size()>list1.size()){
            int run=list1.size();
            for(int i=0;i<run;i++){
               if(list2.contains(list1.get(i))){
                   int index=list2.indexOf(list1.get(i));
                   list2.remove(index);
               } 
            }
            finalCh=(char)list2.get(0);
        }
        
        return finalCh;
    }
}
