
public class StringToNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String str = "2345";
			int finalValue = 0;
			for(int i=0;i<str.length();i++) {
				finalValue = finalValue*10 + str.charAt(i)-'0';
			}
			System.out.println(finalValue);
	}
}
