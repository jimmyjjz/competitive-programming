import java.util.*;
import java.io.*;
public class MagicSequence{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		long pre = 1, now = 2, sum = 4;
		int n = readInt();
		if(n<3) {
			System.out.println(n);
			return;
		}
		for(int i = 0; i<n-3; i++) {
			long temp = now;
			now+=pre;
			pre=temp;
			sum+=now;
		}
		//System.out.println(now);
		System.out.println(sum);
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