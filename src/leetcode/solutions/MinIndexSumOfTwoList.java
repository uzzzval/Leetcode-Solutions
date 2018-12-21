package leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class MinIndexSumOfTwoList {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List arrayList1=new ArrayList();
        List arrayList2=new ArrayList();
        List indexList=new ArrayList();
        List finalResultList=new ArrayList();
        Map newMap=new HashMap();
        for(int i=0;i<list1.length;i++){
            arrayList1.add(list1[i]);
        }
        for(int i=0;i<list2.length;i++){
            arrayList2.add(list2[i]);
        }
        System.out.println(arrayList1);
        System.out.println(arrayList2);
        Iterator arrayList1Iterator=arrayList1.iterator();
        while(arrayList1Iterator.hasNext()){
            String andyFav=arrayList1Iterator.next().toString();
            if(arrayList2.contains(andyFav)){
                int andyIndex=arrayList1.indexOf(andyFav);
                int dorisIndex=arrayList2.indexOf(andyFav);
                int index=andyIndex+dorisIndex;
                newMap.put(andyFav,index);
                indexList.add(index);
            }
        }
        Collections.sort(indexList);
        int minIndex=Integer.parseInt(indexList.get(0).toString());
        Iterator<Map.Entry<String,String>> newMapIterator=newMap.entrySet().iterator();
        while(newMapIterator.hasNext()){
            Map.Entry entry = newMapIterator.next();
            int index=Integer.parseInt(entry.getValue().toString());
            if(index==minIndex){
                finalResultList.add(entry.getKey());
            }
        }
        String[] returnArray=new String[finalResultList.size()];
        for(int i=0;i<finalResultList.size();i++){
            returnArray[i]=finalResultList.get(i).toString();
        }
        return returnArray;
    }
}
