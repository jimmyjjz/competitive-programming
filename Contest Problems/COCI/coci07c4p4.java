import java.util.*;
import java.io.*;
public class Muzicari{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt(), N = readInt();
		int[] musician = new int[N];
		for(int i = 0; i<N; i++)musician[i]=readInt();
		int[][] dp = new int[N+1][T+1];
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=T; j++) {
				if(musician[i-1]<=j)dp[i][j]=Math.max(dp[i-1][j], dp[i-1][j-musician[i-1]]+musician[i-1]);
				else dp[i][j]=dp[i-1][j];
			}
		}
		int[] result = new int[N];
		Arrays.fill(result,-1);
		int i = N, j = T;
		while(i>0) {
			if(dp[i][j]==dp[i-1][j])i--;
			else {
				j-=musician[i-1];
				result[i-1]=j;
				i--;
			}
		}
		int sum = 0;
		for(i = 0; i<N; i++) {
			if(result[i]==-1) {
				result[i]=sum;
				sum+=musician[i];
			}
		}
		for(i = 0; i<N; i++)System.out.print(result[i]+" ");
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