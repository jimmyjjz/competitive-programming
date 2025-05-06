import java.util.*;
import java.io.*;
public class GroupProject{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(),M = readInt(),Q = readInt(),cnt=0;
		Set<Integer> adj[] = new Set[N+1];
		for(int i=1; i<=N; i++) adj[i] = new HashSet<>();
		for(int i=1; i<=M; i++) {
			int u = readInt(), v = readInt();
			if(adj[u].size()==1&&adj[adj[u].iterator().next()].size()>=2)cnt++;
			if(adj[v].size()==1&&adj[adj[v].iterator().next()].size()>=2)cnt++;
			adj[u].add(v);
			adj[v].add(u);
			if(adj[u].size()>=2&&adj[v].size()>=2)cnt++;
		}
		System.out.println(cnt>0?"YES":"NO");
		for(int i=1; i<=Q; i++) {
			int u = readInt(), v = readInt();
			if(adj[u].contains(v)) {
				adj[u].remove(v); adj[v].remove(u);
				if(adj[u].size()>=1&&adj[v].size()>=1)cnt--;
				if(adj[u].size()==1&&adj[adj[u].iterator().next()].size()>=2)cnt--;
				if(adj[v].size()==1&&adj[adj[v].iterator().next()].size()>=2)cnt--;
			}
			else {
				if(adj[u].size()==1&&adj[adj[u].iterator().next()].size()>=2)cnt++;
				if(adj[v].size()==1&&adj[adj[v].iterator().next()].size()>=2)cnt++;
				adj[u].add(v); 
				adj[v].add(u);
				if(adj[u].size()>=2&&adj[v].size()>=2)cnt++;
			}
			System.out.println(cnt>0?"YES":"NO");
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