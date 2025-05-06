import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class RimuruNumber {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int cnt = 0;
	static long N;
	public static void gen(String s) {
		if(Long.parseLong(s) >= N) {
			return;
		}
		cnt++;
		gen(s+2);
		gen(s+3);
	}
	public static void main(String[] args) throws IOException{ 
		N = readLong();
		gen("2");
		gen("3");
		System.out.println(cnt);
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