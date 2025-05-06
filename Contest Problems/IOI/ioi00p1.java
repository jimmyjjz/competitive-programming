import java.util.*;
import java.io.*;
public class Palindromes{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		String o = readLine(), r = new StringBuilder(o).reverse().toString();
		int[] top = new int[N+1], bottom = new int[N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++){
				if(o.charAt(i-1)==r.charAt(j-1))bottom[j]=top[j-1]+1;
				else bottom[j]=Math.max(top[j], bottom[j-1]);
			}
			top=bottom.clone();
		}
		System.out.println(N-bottom[N]);
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