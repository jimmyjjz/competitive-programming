import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class nastynum {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> B = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int fixed = 0;
		int save = 0;
		boolean flag = false;
		for(int i = 0; i<n; i++) {
			int var = sc.nextInt();
			flag = false;
			for(int j = 1; j<var/2; j++) {
				if(var % j == 0) {
					A.add(var/j);
					B.add(j);
				}
			}
			fixed = A.size();
			for(int k = 0; k<fixed; k++) {
				save = Math.max(A.get(k),B.get(k))-Math.min(A.get(k),B.get(k));
				for(int z = 0; z<fixed; z++) {
					if(save == A.get(z)+B.get(z)) {
						flag = true;
					}
				}
			}
			if(flag) {
				System.out.println(var+" is nasty");
			}
			else {
				System.out.println(var+" is not nasty");
			}
			A.clear();
			B.clear();
		}
	}

}