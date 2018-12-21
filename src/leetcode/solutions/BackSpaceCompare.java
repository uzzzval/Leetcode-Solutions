package leetcode.solutions;

import java.util.Stack;

class BackSpaceCompare {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack1 = new Stack<>();
		Stack<Character> stack2 = new Stack<>();
        
        char[] charArray1 = S.toCharArray();
		char[] charArray2 = T.toCharArray();
		for(int i=0;i<charArray1.length;i++) {
			if(charArray1[i]!='#') {
				stack1.push(charArray1[i]);
			}else {
				if(!stack1.isEmpty())
					stack1.pop();
			}
		}
		
		for(int i=0;i<charArray2.length;i++) {
			if(charArray2[i]!='#') {
				stack2.push(charArray2[i]);
			}else {
				if(!stack2.isEmpty())
					stack2.pop();
			}
		}
        return stack1.equals(stack2);
    }
}
