import java.util.Scanner;
public class primeround {
	public static boolean checkprime(int input) {
		if(input == 0 || input == 1) {
			return false;
		}
		else {
			int check = input/2;
			for(int i = 2; i<=check; i++) {
				if(input%i == 0) {
					return false;
				}
			}
			return true;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		int saveL = 0;
		int saveH = 0;
		int differL = 0;
		int differH = 0;
		for(int i = 0; i<5; i++) {
			int N = sc.nextInt();
			flag = false;
			saveL = N;
			while(true) {
				saveL--;
				if(flag) {
					if(checkprime(saveL)) {
						break;
					}
				}
				if(checkprime(saveL)) {
					flag = true;
				}
			}
			flag = false;
			saveH = N;
			while(true) {
				saveH++;
				if(flag) {
					if(checkprime(saveH)) {
						break;
					}
				}
				if(checkprime(saveH)) {
					flag = true;
				}
			}
			differL = N-saveL;
			differH = saveH-N;
			if(differL == differH) {
				System.out.println(saveH);
				continue;
			}
			if(Math.min(differL,differH) == differL) {
				System.out.println(saveL);
			}
			else {
				System.out.println(saveH);
			}
		}
		
	}

}