import java.util.*;
import java.io.*;
public class WoodcuttingGame{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static short[][][][] dp = new short[2][301][2][301];
	public static short r(int a, int b, int c, int d) {
		if(dp[a][b][c][d]==0) {
			if(a==1&&r(0,b,0,b)==1)dp[a][b][c][d]=2;
			for(int i = 1; b-i>0; i++)if(r(a,i,a,b-i)==1)dp[a][b][c][d]=2;
			if(c==1&&r(0,d,0,d)==1)dp[a][b][c][d]=2;
			for(int i = 1; d-i>0; i++)if(r(c,i,c,d-i)==1)dp[a][b][c][d]=2;
			if(a==1&&r(0,b,c,d)==1)dp[a][b][c][d]=2;
			for(int i = 1; b-i>0&&i<=10; i++)if(r(a,b-i,c,d)==1)dp[a][b][c][d]=2;
			if(c==1&&r(a,b,0,d)==1)dp[a][b][c][d]=2;
			for(int i = 1; d-i>0&&i<=10; i++)if(r(a,b,c,d-i)==1)dp[a][b][c][d]=2;
			if(dp[a][b][c][d]==0)dp[a][b][c][d]=1;
		}
		return dp[a][b][c][d];
	}
	public static void main(String[] args) throws IOException{
		System.out.println(r(readInt()-1,readInt(),readInt()-1,readInt())==2?"W":"L");
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