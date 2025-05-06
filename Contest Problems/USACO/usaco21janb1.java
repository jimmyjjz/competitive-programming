import java.util.Scanner;
public class moo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String alpha = sc.nextLine();
		String word = sc.nextLine();
		Character target = ' ';
		int count = 0;
		int place = 0;
		int times = 1;
		while(true) {
			if(place == alpha.length()) {
				place = 0;
				times++;
			}
			if(count == word.length()) {
				break;
			}
			target = word.charAt(count);
			if(target == alpha.charAt(place)) {
				count++;
				place++;
				continue;
			}
			else {
				place++;
			}
		}
		System.out.println(times);
	}

}