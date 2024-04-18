import java.util.*;
import java.io.*;
public class TreeColoring{
	static class des{
		int node, weight;
		public des(int node, int weight) {
			this.node=node;
			this.weight=weight;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		List<des>[] tree = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)tree[i]=new ArrayList<des>();
		for(int i = 1; i<N; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			tree[a].add(new des(b,c));
			tree[b].add(new des(a,c));
		}
		Queue<des> cur = new LinkedList<des>();
		boolean[] visited = new boolean[N+1], status = new boolean[N+1];
		cur.add(new des(1,0));
		while(!cur.isEmpty()) {
			des poll = cur.poll();
			if(!visited[poll.node]) {
				visited[poll.node]=true;
				for(des d : tree[poll.node])cur.add(new des(d.node,(poll.weight+d.weight)%2));
			}
			if(poll.weight%2==0)status[poll.node]=true;
		}
		for(int i = 1; i<=N; i++)System.out.print(status[i]?1+" ":0+" ");
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