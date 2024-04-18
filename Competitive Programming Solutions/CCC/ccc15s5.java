import java.util.*;
import java.io.*;
public class GreedyForPies{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int dp[][][][],N,M,pies[],provided[];
	static boolean[][][][] been;
	static int r(int i, boolean took, int l, int r) {
		int res = 0;
		if(been[i][took?1:0][l][r])return dp[i][took?1:0][l][r];
        if(!took&&i<N)res=Math.max(res, r(i+1,true,l,r)+pies[i]);
        if(i<N)res=Math.max(res,r(i+1,false,l,r));
		if(!took&&l<=r)res=Math.max(res,r(i,true,l,r-1)+provided[r]);
        if(l<=r)res=Math.max(res,r(i,false,l+1,r));
        been[i][took?1:0][l][r]=true;
        dp[i][took?1:0][l][r]=res;
		return res;
	}
	public static void main(String[] args) throws IOException{
		N = readInt();
		pies = new int[N];
		for(int i = 0; i<N; i++)pies[i]=readInt();
		M = readInt();
		provided = new int[M+1];
		for(int i = 1; i<=M; i++)provided[i]=readInt();
		Arrays.sort(provided);
		dp = new int[N+1][2][M+2][M+2];
		been = new boolean[N+1][2][M+2][M+2];
		System.out.println(r(0,false,1, M));
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