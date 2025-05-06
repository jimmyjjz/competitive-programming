import java.util.*;
import java.io.*;
public class QueryingPresents{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		long values[] = new long[1000001];
		values[2]=1;
		for(int i = 3; i<=1000000; i++) {
			if(i%2==1)values[i]=(values[i-1]*i-1)%1000000007;
			else values[i]=(values[i-1]*i+1)%1000000007;
		}
		for(int i = 0; i<T; i++)System.out.println(values[readInt()]);
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