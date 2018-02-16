class Solution {
    public int maxSubArray(int[] nums) {
        int max_so_far=0, max_ending_here=0;
        int length=nums.length;
        if(length==1) return nums[0];
        boolean allNegative=true;
        for(int i=0;i<length;i++){
            if(nums[i]>0 || !allNegative)
                allNegative=false;
            max_ending_here=max_ending_here+nums[i];
        
            if(max_so_far<max_ending_here)
                max_so_far=max_ending_here;
            
            if(max_ending_here<0)
                max_ending_here=0;
        }
        int smallest=0;
        if(allNegative){
            smallest=nums[0];
            for(int i=1;i<length;i++){
                if(nums[i]>smallest)
                    smallest=nums[i];
            }
        }
        if(smallest!=0)
           max_so_far=smallest; 
        return max_so_far;
    }
}
