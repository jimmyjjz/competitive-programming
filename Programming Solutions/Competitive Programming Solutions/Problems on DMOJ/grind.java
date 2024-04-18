import java.util.*;
import java.io.*;
public class Grinding {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt();
	int[] sum = new int[10000001];
	for(int i = 0; i<N; i++) {
		sum[readInt()]++;
		sum[readInt()]--;
	}
	int max = 0;
	for(int i = 1; i<10000001; i++) {
		sum[i]+=sum[i-1];
		max = Math.max(max, sum[i]);
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