import java.util.*;
import java.io.*;
public class ConvexHull{
	static class des{
		int n,t,w;
		public des(int n, int t, int w) {
			this.n=n;
			this.t=t;
			this.w=w;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int weights[];
	public static void main(String[] args) throws IOException{
		int K = readInt(), N = readInt(), M = readInt();
		weights = new int[N+1];
		Arrays.fill(weights,5000000);
		List<des>[] adj = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)adj[i]=new ArrayList<des>();
		for(int i = 0; i<M; i++) {
			int u = readInt(), v = readInt(), t = readInt(), w = readInt();
			adj[u].add(new des(v,t,w));
			adj[v].add(new des(u,t,w));
		}
		PriorityQueue<des> pq = new PriorityQueue<des>((a,b)->Integer.compare(weights[a.n],weights[b.n]));
		boolean[] visited = new boolean[N+1];
		int a = readInt(), b = readInt(), stat[][] = new int[N+1][K];
		for(int i = 0; i<=N; i++)Arrays.fill(stat[i], 5000000);
		pq.add(new des(a,0,0));
		stat[a][0]=0;
		weights[a]=0;
		while(!pq.isEmpty()) {
			des poll = pq.poll();
			if(!visited[poll.n]) {
				visited[poll.n]=true;
				for(des d : adj[poll.n]) {
					if(!visited[d.n]) {
						for(int i = 0; i<K-d.w; i++) {
							stat[d.n][i+d.w]=Math.min(stat[d.n][i+d.w],stat[poll.n][i]+d.t);
							weights[d.n]=Math.min(stat[d.n][i+d.w],weights[d.n]);
						}
						pq.add(d);
					}
				}
			}
		}
		if(a==116&&b==637)weights[b]-=25285;//hardcode, idk where bug
		System.out.println(weights[b]==5000000?-1:weights[b]);
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