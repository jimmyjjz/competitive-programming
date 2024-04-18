import java.util.*;
import java.io.*;
public class Segments{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), a = 1, b = 1, ma = 0, mb = 0;
		for(int i = 0; i<N; i++) {
			int x = readInt(), y = readInt(), tempa = ma, tempb = mb;
			ma=Math.min(tempa+Math.abs(a-y)+Math.abs(y-x), tempb+Math.abs(b-y)+Math.abs(y-x));
			mb=Math.min(tempa+Math.abs(a-x)+Math.abs(y-x), tempb+Math.abs(b-x)+Math.abs(y-x));
			a=x;
			b=y;
		}
		System.out.println(Math.min(ma+N-1+N-a,mb+N-1+N-b));
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