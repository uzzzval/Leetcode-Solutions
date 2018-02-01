class SplitLinkedListInParts {
    public int findMin(int[] nums) {
        int length=nums.length;
        if(length==1) return nums[0];
        if(length==0) return 0;
        
        List arrayList=new ArrayList();
        for(int i=0;i<length;i++){
            arrayList.add(nums[i]);
        }

        Collections.sort(arrayList);
        return Integer.parseInt(arrayList.get(0).toString());
    }
}
