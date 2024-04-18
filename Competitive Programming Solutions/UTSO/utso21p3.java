import java.util.*;
import java.io.*;
public class LatinClass{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		long N = readLong(), pre = readLong(), num = 1, add = 1;
		for(int i = 1; i<N; i++) {
			long in = readLong();
			if(in>=pre) {
				pre=in;
				num=add+1;
				num%=1000000007;
			}
			add+=num;
			add%=1000000007;
		}
		System.out.println(num);
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