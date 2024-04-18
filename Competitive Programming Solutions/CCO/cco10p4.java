import java.util.*;
import java.io.*;
public class ComputerPurchaseReturn{
	static class stat{
		int c,v;
		stat(int c, int v){
			this.c=c;
			this.v=v;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt(), N = readInt();
		List<stat>[] components = new ArrayList[N+1];
		for(int i = 1; i<=T; i++)components[i]=new ArrayList<stat>();
		for(int i = 0; i<N; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			components[c].add(new stat(a,b));
		}
		int B = readInt(), dp[][] = new int[T+1][B+1];
		for(int i = 1; i<=T; i++) {
			for(int j = 0; j<=B; j++) {
				try{dp[i][j]=dp[i][j-1];}catch(Exception e) {}
				for(stat k : components[i])try{dp[i][j]=Math.max(dp[i][j],dp[i-1][j-k.c]+k.v);}catch(Exception e) {}
			}
		}
		System.out.println(dp[T][B]==0?-1:dp[T][B]);
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