import java.util.*;
import java.io.*;
public class Permutation{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long[][] dp = new long[N+1][N+1];
		String s = readLine();
		for(int i = 1; i<=N; i++)dp[1][i]=1;
		for(int i = 2; i<=N; i++) {
			for(int j = 1; j<=i; j++) {
			if(s.charAt(i-2)=='>')dp[i][j]=(dp[i-1][N]-dp[i-1][j-1])%1000000007;
			else dp[i][j]=dp[i-1][j-1]%1000000007;
			}
			for(int j = 1; j<=N; j++)dp[i][j]=dp[i][j]+dp[i][j-1];
		}
		System.out.println(dp[N][N]%1000000007);
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