package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class NextGreaterElementI {
	public static void main(String args[]) {
		int[] nums1= {4,1,2};
		int[] nums2= {1,3,4,2};

		int[] result=nextGreaterElement(nums1,nums2);
		System.out.println(Arrays.toString(result));
	}

	public static int[] nextGreaterElement(int[] nums1,int[] nums2) {
		if(nums1==null) return new int[-1];
		int length1=nums1.length;
		int length2=nums2.length;
		int[] result=new int[length1];
		List<Integer> numberList=new ArrayList<Integer>();
		for(int i=0;i<length2;i++) {
			numberList.add(nums2[i]);
		}

		for(int i=0;i<length1;i++) {
			boolean flag=false;
			for(int j=0;j<length2;j++) {
				if(numberList.get(j)==nums1[i]) {
					flag=true;
				}
				if(flag && numberList.get(j)>nums1[i]) {
					result[i]=numberList.get(j);
					break;
				}else {
					result[i]=-1;
				} 	
			}
		}
		return result;
	}
}
