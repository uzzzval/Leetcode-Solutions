package leetcode.solutions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        Map<Character, Integer> patternMap = new HashMap<>();
        List<String> returnList = new ArrayList<String>();
        int count = 0;
        String patternInt = "";
        for(int i=0;i<pattern.length();i++){
            if(patternMap.containsKey(pattern.charAt(i))){
                patternInt = patternInt + patternMap.get(pattern.charAt(i));
            }else{
                count++;
                patternInt = patternInt + count;
                patternMap.put(pattern.charAt(i), count);
            }
        }
        
        for(String word: words){
           int localCount = 0;
           String localPattern = "";
           Map<Character, Integer> localMap = new HashMap<>(); 
           for(int i=0;i<word.length();i++){
            if(localMap.containsKey(word.charAt(i))){
                localPattern = localPattern + localMap.get(word.charAt(i));
                }else{
                localCount++;
                localPattern = localPattern + localCount;
                localMap.put(word.charAt(i), localCount);
                 }
            }
           
            if(localPattern.equals(patternInt))
                returnList.add(word);
        }
        
        
        return returnList;
    }
}
