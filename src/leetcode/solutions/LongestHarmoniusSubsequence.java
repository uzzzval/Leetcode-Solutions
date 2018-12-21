package leetcode.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        List lengthList=new ArrayList();
        System.out.println(Arrays.toString(nums));
        Map indexMap=new HashMap();
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>i;j--){
                if(nums[j]-nums[i]==1){
                    int length=j-i+1;
                    indexMap.put(i,length);
                    break;
                }
            }
        }

        Iterator<Map.Entry<String, String>> itr = indexMap.entrySet().iterator();
        while(itr.hasNext())
        {
             Map.Entry<String, String> entry = itr.next();
             lengthList.add(entry.getValue());
        }
        Collections.sort(lengthList);
        
        if(lengthList.isEmpty())
        	 return 0;
        else
        	return Integer.parseInt(lengthList.get(lengthList.size()-1).toString());
    }
}
