import java.util.*;
import java.io.*;
public class AGraphProblem {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long max = 0;
		long total = 0;
		for(int i = 0; i<N; i++) {
			long save = readLong();
			total+=save;
			max=Math.max(max, save);
		}
		//if current max over sum then graph cant come down
		if(total%2!=0 || total-max<max) {
			System.out.println("NO");
		}
		else {
			System.out.println("YES");
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