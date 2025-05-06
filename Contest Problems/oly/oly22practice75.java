import java.util.*;
import java.io.*;
public class StringOverlap{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int prefixSufix(String a, String b) {
		int len = Math.min(a.length(), b.length()), cnt = 0;
		for(int i = 0; i<len; i++) {
			if(a.substring(0,i).equals(b.substring(b.length()-i)))cnt=i;
		}
		return cnt;
	}
	public static void main(String[] args) throws IOException{
		String a = readLine(), b = readLine();
		int max = 0;
		max=Math.max(prefixSufix(a,b),max);
		max=Math.max(prefixSufix(b,a),max);
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