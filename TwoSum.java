class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int diff = 0;
        int length = nums.length;
        for(int i = 0;i < length-1;i++){
            diff = target - nums[i];
            if (diff !=0){
                for (int j = i+1;j<length;j++){
                    if (nums[j]==diff){
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }  
            } else if (diff == 0){
                for (int j = i+1 ;j<length;j++){
                    if (nums[j]==0){
                        result[0] = i;
                        result[1] = j;
                        break;
                    }
                }
            }
        }
        return result;
    } 
}
