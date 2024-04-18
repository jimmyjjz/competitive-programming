import java.util.*;
import java.io.*;
public class HatSwap{
	static class stat{
		int n,m;
		public stat(int n, int m) {
			this.n=n;
			this.m=m;
		}
	}
	static class SortbyM implements Comparator<stat>{
		public int compare(stat a, stat b) {
			return Integer.compare(a.m, b.m);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), hats[] = new int[N];
		for(int i = 0; i<N; i++)hats[i]=readInt();
		List<Integer>[] adj = new ArrayList[N+1];
		List<stat>[][] best = new ArrayList[N+1][2];
		for(int i = 1; i<=N; i++) {
			best[i][0]=new ArrayList<stat>();
			best[i][1]=new ArrayList<stat>();
			adj[i]=new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		Queue<stat> bfs = new LinkedList<stat>();
		bfs.add(new stat(1,0));
		boolean[] visited = new boolean[N+1];
		while(!bfs.isEmpty()) {
			stat poll = bfs.poll();
			if(!visited[poll.n]) {
				best[hats[poll.n-1]][0].add(new stat(poll.n,poll.m));
				visited[poll.n]=true;
				for(int v : adj[poll.n])bfs.add(new stat(v,poll.m+1));
			}
		}
		bfs = new LinkedList<stat>();
		bfs.add(new stat(N,0));
		visited = new boolean[N+1];
		while(!bfs.isEmpty()) {
			stat poll = bfs.poll();
			if(!visited[poll.n]) {
				best[hats[poll.n-1]][1].add(new stat(poll.n,poll.m));
				visited[poll.n]=true;
				for(int v : adj[poll.n])bfs.add(new stat(v,poll.m+1));
			}
		}
		int min = Integer.MAX_VALUE;
		for(int i = 1; i<=N; i++) {
			if(!best[i][0].isEmpty()&&!best[i][1].isEmpty()) {
				if(best[i][0].get(0).n!=best[i][1].get(0).n) {
					min=Math.min(min,best[i][0].get(0).m+best[i][1].get(0).m);
					continue;
				}
				if(best[i][0].size()>1)min=Math.min(min,best[i][0].get(1).m+best[i][1].get(0).m);
				if(best[i][1].size()>1)min=Math.min(min,best[i][0].get(0).m+best[i][1].get(1).m);
			}
		}
		System.out.println(min==Integer.MAX_VALUE?-1:min);
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