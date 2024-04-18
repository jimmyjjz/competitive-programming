import java.util.Scanner;
public class DNA {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int match = 0;
		int useless = sc.nextInt();
		sc.nextLine();
		String input = sc.nextLine();
		String molecules = "ACGTU";
		int T = 0;
		int U = 0;
		for(int i = 0; i<input.length(); i++) {
			match = 0;
			for(int j = 0; j<molecules.length(); j++) {
				if(input.charAt(i) == molecules.charAt(j)) {
					continue;
				}
				else {
					match++;
				}
			}
			if(match == 5) {
				System.out.println("neither");
				System.exit(0);
			}
			if(input.charAt(i) == 'T') {
				T++;
			}
			if(input.charAt(i) == 'U') {
				U++;
			}
		}
		if(T > 0 && U > 0) {
			System.out.println("neither");
		}
		else {
		if(T > 0) {
			System.out.println("DNA");
		}
		if(U > 0) {
			System.out.println("RNA");
		}
		if(T == 0 && U == 0) {
			System.out.println("both");
		}
	}
	}

}