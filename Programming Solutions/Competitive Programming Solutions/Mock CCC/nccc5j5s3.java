import java.util.*;
import java.io.*;
public class DirectedGraphConnectivity {
	public static class edge{
		int x,y;
		public edge(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		List<Integer>[] original = new ArrayList[N+1];
		edge[] store = new edge[M];
		for(int i = 1; i<=N; i++) {
			original[i]=new ArrayList<Integer>();
		}
		for(int i = 0; i<M; i++) {
			int a = readInt(), b = readInt();
			store[i]=new edge(a,b);
			original[a].add(b);
		}
		for(int i = 0; i<M; i++) {
			List<Integer>[] tree = new ArrayList[N+1];
			for(int j = 1; j<=N; j++) {
				tree[j]=new ArrayList<Integer>(original[j]);
			}
			tree[store[i].x].remove(tree[store[i].x].indexOf(store[i].y));
			boolean[] valid = new boolean[N+1];
			List<Integer> current = new ArrayList<Integer>();
			current.add(1);
			//bfs
			out:{
			for(int j = 0; j<current.size(); j++) {
				int save = current.get(j);
				if(save==N) {
					System.out.println("YES");
					break out;
				}
				if(!valid[save]) {
					valid[save]=true;
					for(int in : tree[save]) {
						current.add(in);
					}
				}
			}
			System.out.println("NO");
			}
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