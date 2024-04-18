import java.util.*;
import java.io.*;
public class GoldenLily{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int L = readInt(), D = readInt();
		int[][] board = new int[D][L];
		for(int i = 0; i<D; i++) {
			for(int j = 0; j<L; j++)board[i][j]=readInt();
		}
		int[][] dp = new int[D][L];
		for(int i = 0; i<D; i++) {
			for(int j = 0; j<L; j++)dp[i][j]=Integer.MAX_VALUE;
		}
		dp[0][0]=board[0][0];
		for(int i = 1; i<L; i++)dp[0][i]=board[0][i]+dp[0][i-1];
		for(int i = 1; i<D; i++) {
			for(int j = 0; j<L; j++) {
				int min = Integer.MAX_VALUE;
				try {min=Math.min(min, dp[i-1][j]);}catch(Exception e) {}
				try {min=Math.min(min, dp[i][j-1]);}catch(Exception e) {}
				try {min=Math.min(min, dp[i][j+1]);}catch(Exception e) {}
				dp[i][j]=min+board[i][j];
			}
			for(int j = L-1; j>=0; j--) {
				int min = Integer.MAX_VALUE;
				try {min=Math.min(min, dp[i-1][j]);}catch(Exception e) {}
				try {min=Math.min(min, dp[i][j-1]);}catch(Exception e) {}
				try {min=Math.min(min, dp[i][j+1]);}catch(Exception e) {}
				dp[i][j]=min+board[i][j];
			}
		}
//		for(int i = 0; i<D; i++) {
//			for(int j = 0; j<L; j++)System.out.print(dp[i][j]+" ");
//			System.out.println();
//		}
		int l = readInt(), d = readInt();
		System.out.println(dp[d][l]);
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