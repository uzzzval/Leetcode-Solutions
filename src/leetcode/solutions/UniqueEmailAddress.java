package leetcode.solutions;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
	public static void main(String[] args) {
       String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
       int count = numUniqueEmails(emails);
       System.out.println(count);
	}
	
	public static int numUniqueEmails(String[] emails) {
		Set<String> uniqueSet = new HashSet<String>();
        for (String email:emails){
            String[] emailSplit = email.split("@");
            String localString = emailSplit[0];
            localString = localString.replace(".", "");
            int plusPosition=0;
            for(int j=0;j<localString.length();j++) {
            	if(localString.charAt(j)=='+') {
            		plusPosition = j;
            		break;
            	}
            }
            if(plusPosition>0) {
            	localString = localString.substring(0, plusPosition);
            }
            uniqueSet.add(localString + emailSplit[1]);
        }
        return uniqueSet.size();
    }
}
