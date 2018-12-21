package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] returnArray=new int[2];
        if (nums.length==0) {
            returnArray[0]=-1;
            returnArray[1]=-1;
            return returnArray;
        } 
        else{
         List numList=new ArrayList();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
               numList.add(i); 
        }
            if(numList.size()==0){
              returnArray[0]=-1;
              returnArray[1]=-1;  
            }
            if(numList.size()==1){
               returnArray[0]=Integer.parseInt(numList.get(0).toString());
               returnArray[1]=Integer.parseInt(numList.get(0).toString());
            }
            if(numList.size()>1){
              returnArray[0]=Integer.parseInt(numList.get(0).toString());
              returnArray[1]=Integer.parseInt(numList.get(numList.size()-1).toString());  
            }          
        }
        return returnArray;
    }
}
