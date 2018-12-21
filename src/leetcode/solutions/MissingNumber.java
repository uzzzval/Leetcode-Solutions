package leetcode.solutions;

class MissingNumber {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int returnInt = -1;
        boolean[] flags = new boolean[length+1];
        for(int i=0;i<length;i++){
          int index = nums[i];
          flags[index] = true;  
        }
        for(int i=0;i<flags.length;i++){
            if(!flags[i])
                 returnInt = i;
        }
        return returnInt;
    }
}
