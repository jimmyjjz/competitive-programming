import java.util.*;
import java.io.*;
public class CombiningRiceballs{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] presum;
	static byte[][] dp;
	static int sum(int l, int r) {return presum[r]-presum[l-1];}
	static boolean mergeable(int l, int r) {
		if(dp[l][r]!=0)return dp[l][r]==2?true:false;
		int bot = l, top = r;
		while(bot<=top){
            if(sum(l,bot)==sum(top,r)&&((bot==top-1&&mergeable(l,bot)&&mergeable(top,r))||(mergeable(l,bot)&&mergeable(top,r)&&mergeable(bot+1,top-1)))){
                dp[l][r]=2;
                return true;
            }
            if(sum(l,bot)<sum(top,r))bot++;
            else top--;
        }
		dp[l][r]=1;
		return false;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		presum = new int[N+1];
		dp = new byte[N+1][N+1];
		for(int i = 1; i<=N; i++) {
			presum[i]=presum[i-1]+readInt();
			dp[i][i]=2;
		}
		long max = 0;
		for(int i = 1; i<=N; i++) {
			for(int j = i; j<=N; j++)if(mergeable(i,j))max=Math.max(max,sum(i,j));
		}
		System.out.println(max);
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