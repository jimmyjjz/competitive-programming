import java.util.*;
import java.io.*;
public class Tattarrattat{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<5; i++) {
			String s = readLine(), rev = new StringBuilder(s).reverse().toString();
			int len = s.length();
			int[][] dp = new int[len+1][len+1];
			for(int j = 1; j<=len; j++) {
				for(int k = 1; k<=len; k++) {
					if(s.charAt(j-1)==rev.charAt(k-1))dp[j][k]=dp[j-1][k-1]+1;
					else dp[j][k]=Math.max(dp[j-1][k], dp[j][k-1]);
				}
			}
			System.out.println(dp[len][len]);
		}
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