public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String binaryNumber=Integer.toBinaryString(n);
        char[] binaryArr=binaryNumber.toCharArray();
        int count=0;
        for(int i=0;i<binaryArr.length;i++){
            if(binaryArr[i]=='1')
                count++;
        }
      return count;  
    }
}
