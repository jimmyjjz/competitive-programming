import java.util.*;
import java.io.*;
public class OddDigitSum{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), max = 0;
		for(int i = 0; i<N; i++) {
			String s = readLine();
			int len = s.length(), total = 0;
			for(int j = 0; j<len; j++)if((s.charAt(j)-'0')%2==1)total+=s.charAt(j)-'0';
			max=Math.max(max, total);
		}
		System.out.println(max);
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