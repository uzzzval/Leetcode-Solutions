class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        List numberlist=new ArrayList();
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        for(int i=0;i<nums.length;i++){
            numberlist.add(nums[i]);
        }
        Collections.sort(numberlist);
        return Integer.parseInt(numberlist.get(0)+"");
    }
}
