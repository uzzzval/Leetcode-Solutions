import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TheMaze {

	public static void main(String[] args) {
         String inputString = ">>>*<<*";
         int sum=returnSum(inputString);
         System.out.println(2017+sum);
	}
	
	public static int returnSum(String inputString) {
		char[] charArray=inputString.toCharArray();
        int sum=0;
        int minisum=0;
        
        List<Integer> arrayList=new ArrayList<>();
        List<Integer> subtractList=new ArrayList<>();
        List<Integer> addList=new ArrayList<>();
        for(int i=0;i<charArray.length;i++) {
       	    if(charArray[i]=='<')
       	    	    sum=sum-1;
       	    else if(charArray[i]=='>')
       	    	    sum=sum+1;
       	    else if(charArray[i]=='*' && (i!=0 || i!=1))
       	      	arrayList.add(i);
        }
       
        int multValue=2;
        if (arrayList.size()==1 && inputString.length()==1) return 0;
        if(arrayList.size()==1) {
       	    int value=0;
       	    char ch=charArray[arrayList.get(0)-2];
       	    if(ch=='<')
       	    	  value=-1;
       	    if(ch=='>')
     	    	  value=1;
       	    subtractList.add(value);
       	    addList.add(2*value);
        }else {
       	 for(int i=0;i<arrayList.size()-1;i++) {
         	   if(arrayList.get(i+1)-2==arrayList.get(i)) {
         		 if(charArray[arrayList.get(i)-2]=='<')
         			subtractList.add(-1);
    	         else if(charArray[arrayList.get(i)-2]=='>')
    	        	    subtractList.add(1);
         		 multValue=multValue*2;
         		 if(i==arrayList.size()-2)
         			addList.add(multValue);
         	   }else{
         		   multValue=2;
         		   addList.add(multValue);
         	   }
           }
       	 
        }

        for(int i=0;i<addList.size();i++)
       	  sum=sum+addList.get(i);
        for(int i=0;i<subtractList.size();i++)
      	  sum=sum-subtractList.get(i);
        return sum;
	}
}
