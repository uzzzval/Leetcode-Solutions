class SmallestNumberGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        char returnChar=' ';
        for (int i=0;i<letters.length;i++){
            if(target<letters[i]){
               returnChar= letters[i]; 
               break;
            }  
            if((returnChar==' ') && (i==letters.length-1)){
                returnChar=letters[0];
            }
        }
        return returnChar;
    }
}
