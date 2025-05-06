import java.util.*;
import java.io.*;
public class orderpizza {
	public static double change(double in) {
		if((in/3.00)%1.00!=0) {
			in = Math.floor(in/3.00)+1;
			return in;
		}
		in = Math.floor(in/3.00);
		return in;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		double P = change(readDouble());
		double C = change(readDouble());
		double V = change(readDouble());
		System.out.println((int)(P+C+V));
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