import java.util.*;
import java.io.*;
public class Landscaping{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int M = readInt(), N = readInt();
		long dp[][] = new long[M+1][1<<N];
		int obstacles = 0;
		for(int i = 0; i<N; i++)if(readInt()==0)obstacles|=1<<i;
		List<Integer> ablePre = new ArrayList<Integer>();
		for(int i = 0; i<1<<N; i++) {
			if((i&i<<1)==0&&(i&obstacles)==0) {
				dp[1][i]=1;
				ablePre.add(i);
			}
		}
		for(int i = 2; i<=M; i++) {
			int ob = 0;
			for(int j = 0; j<N; j++)if(readInt()==0)ob|=1<<j;
			List<Integer> ableNow = new ArrayList<Integer>();
			for(int j = 0; j<1<<N; j++)if((j&j<<1)==0&&(j&ob)==0)ableNow.add(j);
			int pre = ablePre.size(), now = ableNow.size();
		        for(int k = 0; k<now; k++){
		            for(int j = 0; j<pre; j++) {
		                if((ablePre.get(j)&ableNow.get(k))!=0)continue;
		                dp[i][ableNow.get(k)]=(dp[i][ableNow.get(k)]+dp[i-1][ablePre.get(j)])%1000000007;
		            }
		        }
		        ablePre=new ArrayList<Integer>(ableNow);
		    }
		long result = 0;
		for(int i = 0; i<1<<N; i++)result=(result+dp[M][i])%1000000007;
		System.out.println(result);
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