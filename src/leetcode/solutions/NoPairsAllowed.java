class Result {

    /*
     * Complete the 'minimalOperations' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts STRING_ARRAY words as parameter.
     */

    public static List<Integer> minimalOperations(List<String> words) {
      List<Integer> returnList = new ArrayList<Integer>();
          for(int i=0; i< words.size(); i++){
              String localString = words.get(i);
              
              int localCount = 0;
              boolean continueFlag = false;
              for(int j=1; j<localString.length();j++){
                  if(localString.charAt(j)==localString.charAt(j-1) && !continueFlag){
                      continueFlag = true;
                      localCount++;
                  }else {
                      continueFlag = false;
                  }
              }
             returnList.add(localCount);
          }
            return returnList;
    }
}


