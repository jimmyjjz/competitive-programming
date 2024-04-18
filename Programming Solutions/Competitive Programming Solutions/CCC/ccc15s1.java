import java.util.Scanner;
import java.util.Stack;
public class number {

	public static void main(String[] args) {
		Stack<Integer> num = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int remember = 0;
		int total = 0;
		for(int i = 0; i<k; i++) {
			remember = sc.nextInt();
			num.push(remember);
			if(remember == 0 && num.peek() == 0) {
				num.pop();
				num.pop();
			}
		}
		remember = num.size();
		for(int j = 0; j<remember; j++) {
			total = total + num.pop();
		}
		System.out.println(total);
	}
}