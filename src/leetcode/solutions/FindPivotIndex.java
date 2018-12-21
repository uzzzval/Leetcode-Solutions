package leetcode.solutions;

class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        if (nums.length==0) return -1;
        int index=0;
        int sum1=0;
        int indexReached=0;
        
        for(int i=0;i<nums.length;i++){
            int sum2=0;
            for(int j=i+1;j<nums.length;j++){
               sum2=sum2+nums[j]; 
            }
            if(sum1==sum2){
                index=i;
                break;
            }
            sum1=sum1+nums[i];
            indexReached++;
        }
        
        if(index==0 && indexReached!=nums.length)
            return 0;
        
        if(index==0 && indexReached==nums.length)
            return -1;
        else if (index==0)
            return -1;
        else
            return index;
    }
}
