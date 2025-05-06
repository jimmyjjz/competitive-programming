import java.util.*;
import java.io.*;
public class GeesevsHawks{
	static class game{
		int status,p;
		public game(int status, int p) {
			this.status=status;
			this.p=p;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[][] dp = new int[N+1][N+1];
		List<game> g = new ArrayList<game>();
		List<game> h = new ArrayList<game>();
		String s = readLine();
		for(int i = 0; i<N; i++)g.add(new game((s.charAt(i)=='W')?1:0,readInt()));
		s=readLine();
		for(int i = 0; i<N; i++)h.add(new game((s.charAt(i)=='W')?1:0,readInt()));
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				if((g.get(i-1).status>h.get(j-1).status&&g.get(i-1).p>h.get(j-1).p)||(g.get(i-1).status<h.get(j-1).status&&g.get(i-1).p<h.get(j-1).p)) {
					dp[i][j]=Math.max(Math.max(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]+g.get(i-1).p+h.get(j-1).p);
				}
				else dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
//		for(int i = 0; i<=N; i++) {
//			for(int j = 0; j<=N; j++)System.out.print(dp[i][j]+" ");
//			System.out.println();
//		}
//		int max
//		for(int i = 0; i<=N; i++) {
//			for(int j = 0; j<=N; j++)max=Math.max(dp[i][j], max);
//		}
		System.out.println(dp[N][N]);
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