import java.util.*;
import java.io.*;
public class MonkeyPotato {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int K = readInt(), D = readInt();
		Set<Integer> filter = new HashSet<Integer>();
		for(int i = 0; i<D; i++) {
			filter.add(readInt());
		}
		List<Integer> digits = new ArrayList<Integer>(filter);
		Collections.sort(digits);
		String out = "";
		if(K != 1) {
		if(digits.get(0) == 0) {
			if(digits.size()==1){
				System.out.println("-1");
				System.exit(0);
			}
			out+=digits.get(1);
			for(int i = 0; i<K-2; i++) {
				out+="0";
			}
			out+=digits.get(1);
		}
		else {
			for(int i = 0; i<K; i++) {
				out+=digits.get(0);
			}
		}
		System.out.println(out);
		}
		else {
			if(digits.get(0) != 0) {
				System.out.println(digits.get(0));
			}
			else{
				if(digits.size()==1) {
					System.out.println("-1");
				}
				else {
				System.out.println(digits.get(1));
				}
			}
		}
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}