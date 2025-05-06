import java.util.*;
import java.io.*;
public class Slimes{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long[] presum = new long[N+1];
		for(int i = 1; i<=N; i++)presum[i]=readInt();
		for(int i = 1; i<=N; i++)presum[i]+=presum[i-1];
		long[][] dp = new long[N+1][N+1];
		for(int i = 0; i<=N; i++) {
			for(int j = 0; j<=N; j++)dp[i][j]=Long.MAX_VALUE;
		}
		for(int i = 1; i<=N; i++)dp[i][i]=0;
		for(int i = N-1; i>=1; i--) {
			for(int j = i+1; j<=N; j++) {
			for(int k = i; k<j; k++)dp[i][j]=Math.min(dp[i][j],dp[k+1][j]+dp[i][k]+presum[j]-presum[i-1]);
			}
		}
//		System.out.println(Arrays.toString(presum));
//		for(int i = 0; i<=N; i++) {
//			for(int j = 0; j<=N; j++)System.out.print(dp[i][j]+" ");
//			System.out.println();
//		}
		System.out.println(dp[1][N]);
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