package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List elementList=new ArrayList();
        List finalList=new ArrayList();
        List finalRangeList=new ArrayList();
        Arrays.sort(nums);
        if(nums.length==1){
            int element=nums[0];
             finalRangeList.add(String.valueOf(element));
        }
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i+1]-nums[i]==1){
                if(!elementList.contains(nums[i]))
                      elementList.add(nums[i]); 
                if(i+1==nums.length-1){
                    elementList.add(nums[i+1]);
                    finalList.add(elementList); 
                }       
            }  
            else{
                if(!elementList.contains(nums[i]))
                elementList.add(nums[i]);
                finalList.add(elementList);
                elementList=new ArrayList();
                elementList.add(nums[i+1]);
                if(i+1==nums.length-1)
                    finalList.add(elementList);
            }     
        }
 
        Iterator finalListIterator=finalList.iterator();
        while(finalListIterator.hasNext()){
            List rangeList=(ArrayList)finalListIterator.next();
            int size=rangeList.size();
            if(size>1)
              finalRangeList.add(rangeList.get(0).toString()+"->"+rangeList.get(size-1).toString());
            if(size==1)
              finalRangeList.add(rangeList.get(0).toString());
        }
        return finalRangeList;
    }
}
