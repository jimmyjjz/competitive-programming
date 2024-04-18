import java.util.*;
import java.io.*;
public class GymTour{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int cnt = 0, cnt2 = 0, max = 0, F;
	static List<Integer>[] adj;
	static boolean[] gym;
	static void dfs1(int n, int pre, int depth) {
		for(int i : adj[n]) {
			if(i != pre) { 
				dfs1(i, n, depth+1);
				if(gym[i]) { 
					cnt++;
					gym[n]=true; 
				}
			}
		}
		if(gym[n])max = Math.max(max, depth);
	}
	static void dfs2(int n, int pre, int depth) {
		for(int i : adj[n]) {
			if(i != pre) { 
				dfs2(i, n, depth+1);
				if(gym[i]||i==F) { 
					cnt2++;
					gym[n]=true; 
				}
			}
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		F = readInt();
		gym = new boolean[N+1];
		for(int i = 0; i<K; i++)gym[readInt()]=true;
		adj = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)adj[i]=new ArrayList<Integer>();
		for(int i = 1; i<N; i++) {
			int a = readInt(), b = readInt();
			adj[a].add(b);
			adj[b].add(a);
		}
		dfs1(1, -1, 0);  
		dfs2(1, -1, 0);
		System.out.println(Math.min(2*cnt-max, cnt2));
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