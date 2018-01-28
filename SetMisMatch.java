class SetMisMatch {
    public int[] findErrorNums(int[] nums) {
        
        int duplicate=0;
        int duplicateIndex=0;
        int missing=0;
       
        int[] values=new int[2];
     
        Arrays.sort(nums);
         for (int i=0;i<nums.length-1;i++){
             if(nums[i]==nums[i+1]){
                 duplicate=nums[i];
             }
        }
        
        List oldList=new ArrayList();
        List newList=new ArrayList();
        for(int i=0;i<nums.length;i++){
            newList.add(i+1);
            oldList.add(nums[i]);
        }
        newList.removeAll(oldList);
        values[0]=duplicate;
        System.out.println(newList);
        values[1]=Integer.parseInt(newList.get(0).toString());
        return values;
    }
}
