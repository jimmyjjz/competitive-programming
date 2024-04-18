import java.util.*;
import java.io.*;
public class Alphabet{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String s = readLine(), alpha = "abcdefghijklmnopqrstuvwxyz";
		int len1 = s.length(), len2 = alpha.length();
		int[][] dp = new int[len1+1][len2+1];
		for(int i = 1; i<=len2; i++)dp[0][i]=i;
		for(int i = 1; i<=len1; i++) {
			for(int j = 1; j<=len2; j++) {
				if(s.charAt(i-1)==alpha.charAt(j-1))dp[i][j]=dp[i-1][j-1];
				else dp[i][j]=Math.min(dp[i][j-1]+1, dp[i-1][j]);
			}
		}
		System.out.println(dp[len1][len2]);
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