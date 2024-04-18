import java.util.*;
import java.io.*;
public class reverse {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		StringTokenizer split = new StringTokenizer(readLine(), " ");
		String a = split.nextToken();
		String b = split.nextToken();
		String compareA = "";
		String compareB = "";
		for(int i = a.length()-1; i>-1; i--) {
		compareA = compareA + a.charAt(i);
		}
		for(int j = b.length()-1; j>-1; j--) {
			compareB = compareB + b.charAt(j);
			}
		long newA = Long.parseLong(compareA);
		long newB = Long.parseLong(compareB);
		System.out.println(Math.min(newA, newB));
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