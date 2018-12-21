package leetcode.solutions;

class BinaryNumberWithAlternatingBits {
    
    //checking if the numberhas alternating bits
    public boolean hasAlternatingBits(int n) {
        
        String binaryNumber=Integer.toBinaryString(n);
        System.out.println(binaryNumber);
        char[] binaryArr=binaryNumber.toCharArray();
        boolean hasAlternate=true;
        
        for(int i=0;i<binaryArr.length-1;i++){
            if(binaryArr[i]==binaryArr[i+1])
                hasAlternate=false;
        }
        
        return hasAlternate;
    }
    
}
