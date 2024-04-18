import java.util.*;
import java.io.*;
public class SuperPlumber{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		while(N!=0&&M!=0) {
		boolean[][] valid = new boolean[N][M];
		char[][] board = new char[N][M];
		for(int i = 0; i<N; i++) {
			String s = readLine();
			for(int j = 0; j<M; j++) {
				if(s.charAt(j)=='.')board[i][j]='0';
				else board[i][j]=s.charAt(j);
			}
		}
		int[][] dp = new int[N][M];
		dp[N-1][0]=(int)(board[N-1][0])-48;
		valid[N-1][0]=true;
		for(int i = N-2; i>=0; i--) {
			if(board[i][0]=='*')break;
			dp[i][0]=dp[i+1][0]+(int)(board[i][0])-48;
			valid[i][0]=true;
		}
		for(int i = 1; i<M; i++) {
			for(int j = 0; j<N; j++) {
				if(!valid[j][i-1])continue;
				int cur = dp[j][i-1];
				for(int k = j; k<N; k++) {
					if(board[k][i]=='*')break;
					cur+=(int)(board[k][i])-48;
					dp[k][i]=Math.max(cur, dp[k][i]);
					valid[k][i]=true;
				}
			}
			for(int j = N-1; j>=0; j--) {
				if(!valid[j][i-1])continue;
				int cur = dp[j][i-1];
				for(int k = j; k>=0; k--) {
					if(board[k][i]=='*')break;
					cur+=(int)(board[k][i])-48;
					dp[k][i]=Math.max(cur, dp[k][i]);
					valid[k][i]=true;
					//System.out.println(k+" "+i+" "+dp[k][i]);
				}
			}
		}
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<M; j++)System.out.print(dp[i][j]+" ");
//			System.out.println();
//		}
		System.out.println(dp[N-1][M-1]);
		N = readInt();
		M = readInt();
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