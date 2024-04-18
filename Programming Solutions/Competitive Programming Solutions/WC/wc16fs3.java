import java.util.*;
import java.io.*;
public class Privacy2{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dp[][],cows[];
	static int treats(int l, int r) {
		int treat = 0;
		for(int k = l; k<=r; k++)treat+=Math.max(0, r-l-cows[k]);
		return treat;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		cows = new int[N+1];
		dp = new int[N+1][K+2];
		for(int i = 0; i<=N; i++)Arrays.fill(dp[i], 400*400+1);
		dp[0][0]=0;
		for(int i = 1; i<=N; i++)cows[i]=readInt();
		for(int i = 1; i<=N; i++) {
			for(int j = i; j<=N; j++) {
				for(int k = 0,treats = treats(i,j); k<=K; k++)dp[j][k+1]=Math.min(dp[j][k+1], dp[i-1][k]+treats);
			}
		}
		//for(int i = 0; i<=N; i++)System.out.println(Arrays.toString(dp[i]));
		System.out.println(dp[N][K+1]);
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