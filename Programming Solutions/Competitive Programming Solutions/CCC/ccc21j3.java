import java.util.Scanner;
public class instruction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String code = "";
		String old = "";
		String save = "";
		int value = 0;
		while(true) {
			code = sc.nextLine();
			if(code.contentEquals("99999")) {
				return;
			}
			save = code.substring(2,code.length());
			value = Character.getNumericValue(code.charAt(0))+Character.getNumericValue(code.charAt(1));
			if(value == 0) {
				System.out.println(old+" "+save);
			}
			else if(value %2==0) {
				old = "right";
				System.out.println(old+" "+save);
			}
			else{
				old = "left";
				System.out.println(old+" "+save);
			}
	}
	}
}