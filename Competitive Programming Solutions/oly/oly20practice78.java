import java.util.*;
import java.io.*;
public class BobsAppleShopping{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class apple{
		int amount,cost;
		public apple(int amount, int cost) {
			this.amount=amount;
			this.cost=cost;
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		int[] dp = new int[M+5001];
		List<apple> apples = new ArrayList<apple>();
		for(int i = 0; i<N; i++)apples.add(new apple(readInt(),readInt()));
		for(apple j : apples)dp[j.amount]=j.cost;
		for(int i = 1; i<=M; i++){
			if(dp[i]!=0) {
				for(apple j : apples) {
					if(dp[i+j.amount]==0)dp[i+j.amount]=dp[i]+j.cost;
					else dp[i+j.amount]=Math.min(dp[i+j.amount], dp[i]+j.cost);
				}
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = M; i<M+5001; i++) {
			if(dp[i]==0)continue;
			min=Math.min(min, dp[i]);
		}
		System.out.println(min);
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