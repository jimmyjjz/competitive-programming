import java.util.*;
import java.io.*;
public class Artskjid{
	static class des{
		int d,w;
		public des(int d, int w){
			this.d=d;
			this.w=w;
		}
	}
	static class status{
		int d,w,v;
		public status(int d, int w, int v){
			this.d=d;
			this.w=w;
			this.v=v;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), dp[][] = new int[N][1<<N];
		List<des>[] tree = new ArrayList[N];
		for(int i = 0; i<N; i++)tree[i]=new ArrayList<des>();
		for(int i = 0; i<M; i++)tree[readInt()].add(new des(readInt(),readInt()));
		Queue<status> cur = new LinkedList<status>();
		cur.add(new status(0,0,1));
		while(!cur.isEmpty()) {
			status poll = cur.poll();
			for(des n : tree[poll.d]) {
				if((poll.v&(1<<n.d))!=0)continue;
				if(dp[n.d][poll.v|(1<<n.d)]==0)cur.add(new status(n.d,n.w,poll.v|(1<<n.d)));
				dp[n.d][poll.v|(1<<n.d)]=Math.max(dp[n.d][poll.v|(1<<n.d)], dp[poll.d][poll.v]+n.w);
			}
		}
		int max = 0;
		for(int i = 0; i<(1<<N); i++)max=Math.max(dp[N-1][i], max);
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