package leetcode.solutions;

class MinAddToValidParentheses {
    public int minAddToMakeValid(String S) {
        int balance = 0, local = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(')
                local++;
            else if(S.charAt(i)==')'){
              if(local>0){
                  local--;
              }  else{
                  balance++;
              }
            } 
        }
        return local+balance;
    }
}
