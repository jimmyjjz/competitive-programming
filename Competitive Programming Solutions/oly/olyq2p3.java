import java.util.*;
import java.io.*;
public class TheKing{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class kingcomb{
		int amount,state;
		public kingcomb(int amount, int state) {
			this.amount=amount;
			this.state=state;
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		List<kingcomb> able = new ArrayList<kingcomb>();
		for(int i = 0; i<1<<N; i++) {
			if((i&(i<<1))!=0)continue;
			int cnt = 0;
			for(int j = 0; j<N; j++)if((i&(1<<j))!=0)cnt++;
			able.add(new kingcomb(cnt,i));
		}
		int size = able.size();
		long dp[][][] = new long[N+1][able.size()][N*N+1];
		for(int i = 0; i<size; i++)dp[1][i][able.get(i).amount]=1;
		for(int r=2; r<=N; r++){
	        for(int k=0; k<size; k++){
	            for(int j=0; j<size; j++) {
	                if(((able.get(j).state|(able.get(j).state<<1)|(able.get(j).state>>1))&able.get(k).state)!=0)continue;
	                for(int z = able.get(k).amount; z<N*N; z++)dp[r][k][z]+=dp[r-1][j][z-able.get(k).amount];
	            }
	        }
	    }
		long result = 0;
		for(int i = 0; i<size; i++)result+=dp[N][i][K];
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