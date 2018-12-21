package leetcode.solutions;

import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'textQueries' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY sentences
     *  2. STRING_ARRAY queries
     */

    public static void textQueries(List<String> sentences, List<String> queries) {
    // Write your code here
        for(String q: queries){
            boolean a = false;
            int i=0;
            for(String s: sentences){
                if(Arrays.asList(s.split(" ")).containsAll(Arrays.asList(q.split(" ")))){
                  System.out.print(i+" ");
                  a = true;
                }
                i++;
            }
            if(!a)
                 System.out.println(-1);
             else
                 System.out.println("");
        }
         
        }
    }


