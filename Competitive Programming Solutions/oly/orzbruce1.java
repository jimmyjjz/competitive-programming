import java.util.*;
import java.io.*;
public class distance {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		StringTokenizer split = new StringTokenizer(readLine(), " ");
		int a = Integer.parseInt(split.nextToken());
		int b = Integer.parseInt(split.nextToken());
		int c = Integer.parseInt(split.nextToken());
		System.out.println(Math.round(((a/4.00)+(b/6.00)+(c/7.00))*60.00/100.00)/100.00);
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