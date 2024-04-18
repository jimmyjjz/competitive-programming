import java.util.Scanner;

public class auction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String winningname = "";
		int winningamount = 0;
		String newname = "";
		int newamount = 0;
		for(int i = 0; i<n; i++) {
			sc.nextLine();//java skips a line while scanning
			newname = sc.nextLine();
			newamount = sc.nextInt();
			if(newamount > winningamount) {
				winningname = newname;
				winningamount = newamount;
			}
		}
		System.out.println(winningname);
	}

}