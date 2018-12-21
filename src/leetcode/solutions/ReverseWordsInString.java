package leetcode.solutions;

public class ReverseWordsInString {
    public String reverseWords(String s) {
         String returnString = "";
        String[] stringArray = s.split(" ");
        for(int i=stringArray.length-1;i>=0;i--){
        	System.out.println(stringArray[i]);
        	if(!(stringArray[i].trim() + " ").equals(" "))
        		returnString = returnString + stringArray[i].trim() + " ";
    }
        return returnString.trim();
    }
}
