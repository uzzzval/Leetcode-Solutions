package leetcode.solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        double median = 0;
        if(length1==0 && length2==0)
            return median;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<length1;i++){
            list.add(nums1[i]);
        }
        
        for(int i=0;i<length2;i++){
            list.add(nums2[i]);
        }
        
        Collections.sort(list);
        System.out.println(list);
        int sizeOfList = list.size();
        if(sizeOfList%2!=0){
            median = list.get(sizeOfList/2);
        }else if(sizeOfList%2==0){
            median = ((double)list.get(sizeOfList/2)+(double)list.get((sizeOfList/2)-1))/2;
        }
        return median;
    }
}
