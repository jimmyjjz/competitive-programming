import java.util.*;
import java.io.*;
public class MaxProfit{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), values[] = new int[N];
		for(int i = 0; i<N; i++)values[i]=readInt();
		long result = 0;
		for(int i = 0; i<N; i++) {
			int cost = readInt();
			if(cost<values[i])result+=values[i]-cost;
		}
		System.out.println(result);
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