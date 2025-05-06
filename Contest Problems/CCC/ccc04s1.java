import java.util.Scanner;
import java.util.ArrayList; 
import java.util.List;
public class prefix {
	public static boolean fix(String current, String compare) {
		String front = "";
		String back = "";
		if(current.length() >= compare.length()) {
			for(int i = 0; i<compare.length(); i++) {
				front = front+current.charAt(i);
				back = back+current.charAt((current.length()-compare.length())+i);
			}
			if(front.equals(compare) || back.equals(compare)) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		List<String> all = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String a = "";
		String b = "";
		String c = "";
		int in = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i<in*3; i++) {
			all.add(sc.nextLine());
		}
			for(int k = 0; k<in; k++) {
				a = all.remove(0);
				b = all.remove(0);
				c = all.remove(0);
				if(fix(a,b) || fix(b,a) || fix(c,b) || fix(b,c) || fix(a,c) || fix(c,a)) {
					System.out.println("No");
				}
				else {
					System.out.println("Yes");
			}
		}
	}
}