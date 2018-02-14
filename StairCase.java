class StairCase {
   
    public int climbStairs(int n) {
       if(n==0) return 1;
       if(n==1) return 1; 
       if(n==2) return 2;
        
       int[] numbers=new int[n+1];
       for(int i=0;i<n;i++){
          numbers[i]=i; 
       }
       
       for(int i=2;i<n;i++){
          numbers[i+1]=numbers[i]+numbers[i-1]; 
       }       
        return numbers[n];
    } 
}
