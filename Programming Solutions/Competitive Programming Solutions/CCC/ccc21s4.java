import java.util.*;
import java.io.*;
public class DailyCommute{
	static class stat{
		int n,m;
		public stat(int n, int m){
			this.n=n;
			this.m=m;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), W = readInt(), D = readInt(), reach[] = new int[N+1], dex[] = new int[N+1], fre[] = new int[2000000];
		List<Integer>[] adj = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) {
			adj[i]=new ArrayList<Integer>();
			reach[i]=1000000;
		}
		for(int i = 0; i<W; i++) {
			int a = readInt(), b = readInt();
			adj[b].add(a);
		}
		Queue<stat> q = new LinkedList<stat>();
		q.add(new stat(N,0));
		boolean[] visited = new boolean[N+1];
		while(!q.isEmpty()) {
			stat poll = q.poll();
			if(!visited[poll.n]) {
				visited[poll.n]=true;
				reach[poll.n]=poll.m;
				for(int v : adj[poll.n])q.add(new stat(v,poll.m+1));
			}
		}
		for(int i = 1; i<=N; i++)dex[i]=readInt();
		TreeSet<Integer> speeds = new TreeSet<Integer>();
		for(int i = 0; i<N; i++){
			speeds.add(reach[dex[i+1]]+i);
			fre[reach[dex[i+1]]+i]++;
		}
		for(int i = 0; i<D; i++) {
			int X = readInt(), Y = readInt();
			if(--fre[reach[dex[X]]+X-1]==0)speeds.remove(reach[dex[X]]+X-1);
			if(--fre[reach[dex[Y]]+Y-1]==0)speeds.remove(reach[dex[Y]]+Y-1);
			int temp = dex[X];
			dex[X]=dex[Y];
			dex[Y]=temp;
			if(++fre[reach[dex[X]]+X-1]==1)speeds.add(reach[dex[X]]+X-1);
			if(++fre[reach[dex[Y]]+Y-1]==1)speeds.add(reach[dex[Y]]+Y-1);
			System.out.println(speeds.first());
		}
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