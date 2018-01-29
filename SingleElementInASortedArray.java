class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        List arrayList=new ArrayList();
        for(int i=0;i<nums.length;i++){
          arrayList.add(nums[i]);  
        }
        Collections.sort(arrayList);
        System.out.println(arrayList);
        int number=-1;
        for(int i=0;i<nums.length-1;i=i+2){
          if(Integer.parseInt(arrayList.get(i)+"")!=Integer.parseInt(arrayList.get(i+1)+"")){
             number=Integer.parseInt(arrayList.get(i)+"");
             break;
          }    
        }
        if(number==-1)
            number=Integer.parseInt(arrayList.get(arrayList.size()-1)+"");
        return number;
    }
}
