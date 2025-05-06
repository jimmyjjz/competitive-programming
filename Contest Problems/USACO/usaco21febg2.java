import java.util.*;
import java.io.*;

public class ModernArt3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), dp[][] = new int[N][N], canva[] = new int[N];
		for(int i = 0; i<N; i++)canva[i]=readInt();
			for(int i = N-1; i>=0; i--){
				for(int j = i+1; j<N; j++){
					if(canva[i]==canva[j])dp[i][j]=Math.max(dp[i][j],dp[i+1][j-1]+1);
					for(int k = i+1; k<j; k++)dp[i][j]=Math.max(dp[i][j],dp[i][k]+dp[k][j]);
				}
		}
			System.out.println(N-dp[0][N-1]);
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}