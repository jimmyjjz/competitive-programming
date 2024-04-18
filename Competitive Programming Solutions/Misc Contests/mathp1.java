import java.util.*;
import java.io.*;
public class Arrays{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int gcd(int a, int b){return b!=0?gcd(b,a%b):a;}
	public static void main(String[] args) throws IOException{
		int N = readInt(), gcd = Math.abs(readInt());
		for(int i = 1; i<N; i++)gcd=gcd(gcd,Math.abs(readInt()));
		System.out.println(gcd);
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