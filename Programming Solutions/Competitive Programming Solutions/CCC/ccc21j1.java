import java.util.Scanner;
public class boiling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int B = sc.nextInt();
		System.out.println(5*B-400);
		if(5*B-400 == 100) {
			System.out.println(0);
		}
		else if(5*B-400 > 100) {
			System.out.println(-1);
		}
		else if(5*B-400 < 100) {
			System.out.println(1);
		}
	}

}