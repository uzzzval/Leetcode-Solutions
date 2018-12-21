package leetcode.solutions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TravelPlan {

	public static void main(String[] args) {
		int[] nums= {1,0,0,0,2,7,0,0,0,0,9};
		int length=nums.length;
		List<Integer> distinctList=new ArrayList<Integer>();
		for(int i=0;i<length;i++) {
			if(!distinctList.contains(nums[i]))
				distinctList.add(nums[i]);
		}
		List<Integer> masterList=distinctList;
		List<Integer> tempList=new ArrayList<Integer>();
		int returnRange=0;
		for(int i=0;i<length;i++) {
			if(tempList.contains(nums[i])) {
				Iterator listIterator=tempList.iterator();
				while(listIterator.hasNext()) {
					int itValue=(int) listIterator.next();
					if(itValue==nums[i])
						listIterator.remove();
				}

				tempList.add(nums[i]);
				int size=tempList.size();
				distinctList.removeAll(tempList);
				if(distinctList.isEmpty()) {
					if(returnRange==0)
						returnRange=size;
					else if (size<returnRange)
						returnRange=size;
					distinctList=masterList;
				}
			}else {

				tempList.add(nums[i]);
				int size=tempList.size();
				distinctList.removeAll(tempList);
				if(distinctList.isEmpty()) {
					if(returnRange==0)
						returnRange=size;
					else if (size<returnRange)
						returnRange=size;
					distinctList=masterList;
				}
			}
		}
		System.out.println(returnRange);
	}

}
