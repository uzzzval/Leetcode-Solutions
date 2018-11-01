class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0 && k==0){
            return new int[0];
        }
        int[] finalArray = new int[nums.length-k+1];
        for(int i=0;i<=nums.length-k;i++){
           int max = getMax(nums, i, i+k);
           finalArray[i]=max;
        }
        return finalArray;
    }
    int getMax(int[] nums, int start, int end){
        int max = nums[start];
        for(int i=start;i<end;i++){
           if(nums[i]>max)
               max = nums[i];
        }
        return max;
    }
}
