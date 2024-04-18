import java.util.*;
import java.io.*;
public class NotEnoughServers{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class state{
		int came,added,cnt;
		public state(int came, int added, int cnt) {
			this.came=came;
			this.added=added;
			this.cnt=cnt;
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		boolean cases[][] = new boolean[N][M];
		for(int i = 0; i<N; i++) {
			String s = readLine();
			for(int j = 0; j<M; j++)cases[i][j]=s.charAt(j)=='X'?true:false;
		}
		int max = 0;
		List<Integer> compressed = new ArrayList<Integer>();
		for(int i = 0; i<M; i++) {
			int temp = 0;
			for(int j = 0; j<N; j++)if(cases[j][i])temp|=1<<j;
			compressed.add(temp);
			max|=temp;
		}
		state[] dp = new state[max+1];
		for(int i = 0; i<M; i++)dp[compressed.get(i)]=new state(-1,i,1);
		for(int i = 0; i<=max; i++) {
			if(dp[i]==null)continue;
			for(int j = 0; j<M; j++)if(dp[i|compressed.get(j)]==null||dp[i|compressed.get(j)].cnt>dp[i].cnt+1)dp[i|compressed.get(j)]=new state(i,j,dp[i].cnt+1);
		}
		state cur = dp[max];
		System.out.println(cur.cnt);
		while(cur.came!=-1) {
			System.out.print((cur.added+1)+" ");
			cur=dp[cur.came];
		}
		System.out.println(cur.added+1);
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