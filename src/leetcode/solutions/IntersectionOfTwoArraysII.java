package leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length==0 || nums2.length==0) return new int[0];
        
        List nums1List=new ArrayList();
        List nums2List=new ArrayList();
        List finalList=new ArrayList();
        
        for(int i=0;i<nums1.length;i++)
            nums1List.add(nums1[i]);
        for(int i=0;i<nums2.length;i++)
            nums2List.add(nums2[i]);
        
        Iterator iterator = nums1List.iterator();
        while(iterator.hasNext()){
            int number=Integer.parseInt(iterator.next().toString());
            if(nums2List.contains(number)){
                finalList.add(number);
                nums2List.remove(nums2List.indexOf(number));
            }
        }
        System.out.println(finalList);
        Collections.sort(finalList);
        int[] returnArray=new int[finalList.size()];
        for(int i=0;i<returnArray.length;i++)
            returnArray[i]=Integer.parseInt(finalList.get(i).toString());
        return returnArray;
    }
}
