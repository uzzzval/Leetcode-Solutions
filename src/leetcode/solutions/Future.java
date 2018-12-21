package leetcode.solutions;

public class Future {
	
	public static void main(String[] args) {
		
		int A=4;
		int K=5;
		int ahead=1;
		int result=minNum(A,K,ahead);
		System.out.println(result);
	}

	public static int minNum(int A, int K,int ahead) {
		int count=0;
		int startingA=0;
		int startingK=0-ahead;
		while(true) {
			if(startingA==0 && startingK==0) {
				startingA=0;
				startingK=0-ahead;
			}
			startingA=startingA+A;
			startingK=startingK+K;
			count++;
			if(startingK>startingA)
				break;
		}
		
		return count;
	}
}
