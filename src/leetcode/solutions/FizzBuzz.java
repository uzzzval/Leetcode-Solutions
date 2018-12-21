package leetcode.solutions;

import java.util.ArrayList;
import java.util.List;

class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> finalList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i%3==0 && i%5==0){
                finalList.add("Fizz"+"Buzz");
            }else if (i%5==0){
                finalList.add("Buzz");
            }else if (i%3==0){
               finalList.add("Fizz"); 
            }else{
                finalList.add(i+"");
            }
        }
        return finalList;
    }
}
