import java.util.*;
import java.io.*;
public class CoinChange{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int tar = readInt(), N = readInt();
		int[] coins = new int[N];
		for(int i = 0; i<N; i++)coins[i]=readInt();
		int[] dp = new int[tar*2+1];
		for(int j : coins)dp[j]=1;
		for(int i = 1; i<tar; i++) {
			if(dp[i]!=0)for(int j : coins)dp[i+j]=Math.min((dp[i+j]==0)?dp[i]+1:dp[i+j], dp[i]+1);
		}
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[tar]);
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