package leetcode.solutions;

class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        
        if(A.length<3) return 0;
        
        int finalReturn = 0;
        int[] difference = new int[A.length-1];
        for(int i=0;i<A.length-1;i++){
            difference[i]=A[i+1]-A[i];
        }
        
        int continuousCount = 0;
        
        for(int i=0;i<difference.length-1;i++){
            if(difference[i+1]==difference[i]){
                continuousCount++;
            }else{
                int localCount = 0;
                for(int j=continuousCount;j>0;j--)
                    localCount = localCount +j;
                finalReturn = finalReturn + localCount;
                continuousCount = 0;
            }
        }
        
        if(continuousCount!=0){
            int localCount = 0;
            for(int j=continuousCount;j>0;j--)
                    localCount = localCount +j;
            finalReturn = finalReturn + localCount;
        }
        return finalReturn;
    }
}
