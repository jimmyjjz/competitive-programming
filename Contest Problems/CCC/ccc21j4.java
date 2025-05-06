import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class books {
	public static void main(String[] args) {
		List<Character> books = new ArrayList<Character>();  
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int countA = 0;
		int countB = 0;
		int countC = 0;
		int countD = 0;
		int subtract = 0;
		int total = 0;
		for(int i = 0; i<input.length(); i++) {
			books.add(input.charAt(i));
		}
		for(int i = 0; i<input.length(); i++) {
			if(books.get(i) == 'L') {
				countA++;
			}
			if(books.get(i) == 'M') {
				countB++;
			}
		}
		for(int j = 0; j<countA; j++) {
			if(books.get(j) != 'L') {
				total++;
			}
			if(books.get(j) == 'M') {
				countC++;
			}
		}
		for(int k = countA; k<countB+countA; k++) {
			if(books.get(countA+(k-countA)) != 'M') {
				total++;
			}
			if(books.get(countA+(k-countA)) == 'L') {
				countD++;
			}
		}
		System.out.println(total-Math.min(countC, countD));
	}

}