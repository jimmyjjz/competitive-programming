import java.util.Scanner;
public class digit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int staple = 0;
		String s = "";
		for(int i = 0; i<5; i++) {
			s = sc.nextLine();
			for(int j = 0; j<s.length(); j++) {
				if(staple < Integer.parseInt(s.charAt(j)+"")) {
				staple = Integer.parseInt(s.charAt(j)+"");
				}
			}
			System.out.println(staple);
			staple = 0;
		}
	}

}