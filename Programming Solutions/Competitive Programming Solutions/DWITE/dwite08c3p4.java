import java.util.*;
import java.io.*;
public class TimeForChange{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<5; i++) {
			int N = readInt(),M = readInt();
			int[] dp = new int[201];
			boolean[] valid = new boolean[201];
			Set<Integer> coins = new HashSet<Integer>();
			for(int j = 0; j<M; j++)coins.add(readInt());
			for(int j : coins) {
				dp[j]=1;
				valid[j]=true;
			}
			for(int j = 1; j<=N; j++) {
				if(valid[j]) {
					for(int k : coins) {
						dp[j+k]=Math.min(dp[j+k]==0?dp[j]+1:dp[j+k], dp[j]+1);
						valid[j+k]=true;
					}
				}
			}
			System.out.println(dp[N]);
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