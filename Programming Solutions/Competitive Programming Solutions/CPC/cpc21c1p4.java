import java.util.*;
import java.io.*;
public class AQTandDirectedGraph{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)graph[i]=new ArrayList<Integer>();
		for(int i = 0; i<M; i++) {
			int a = readInt(), b = readInt();
			graph[b].add(a);
		}
		int[] connect = new int[N+1];
		for(int i = 1; i<=N; i++)connect[i]=i;
		Queue<Integer> bfs = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		for(int i = N; i>0; i--) {
			if(visited[i])continue;
			bfs.add(i);
			while(!bfs.isEmpty()) {
				int poll = bfs.poll();
				if(!visited[poll]) {
					visited[poll]=true;
				for(int j : graph[poll]) {
					bfs.add(j);
					connect[j]=Math.max(connect[j], connect[poll]);
				}
				}
			}
		}
		for(int i = N; i>0; i--) {
			if(connect[i]>i) {
				System.out.println(i+" "+connect[i]);
				return;
			}
		}
		System.out.println(-1);
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