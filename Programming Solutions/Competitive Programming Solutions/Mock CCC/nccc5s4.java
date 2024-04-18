import java.util.*;
import java.io.*;
public class SparseBinaryStringCounting{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int K = readInt(), N = readInt();
		long total = 0;
		int[] ones = new int[N+2];
		ones[N+1]=K;
		for(int i = 1; i<=N; i++)ones[i]=readInt();
		for(int i = 1; i+2<=N; i++) {
			//System.out.println(ones[i]+" "+ones[i-1]+" "+K+" "+ones[i+2]);
			long top = ones[i]-ones[i-1], bottom = K-ones[i+2]+1;
			//System.out.println(top+" "+bottom);
			total+=top*bottom;
		}
		System.out.println(total);
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