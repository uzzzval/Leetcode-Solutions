class DistributeCandies {
    public int distributeCandies(int[] candies) {
        int sizeofArray=candies.length;
        int toBeDividedInto=sizeofArray/2;
        Set candiesSet=new HashSet();
        for (int i=0;i<sizeofArray;i++){
            candiesSet.add(candies[i]);
        }
        if(candiesSet.size()>toBeDividedInto){
            return toBeDividedInto;
        }
        else{
            return candiesSet.size();
        }
    }
}
