import java.util.*;
import java.io.*;
public class PhonomenalReviews{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int e=-1, farthest, diameter;
	static List<Integer> adj[];
	static boolean meet[];
	static void meetup(int n, int pre) {
		for(int i : adj[n]) {
			if(i!=pre) {
				meetup(i,n);
				if(meet[i])meet[n]=true;
			}
		}
		if(meet[n])e++;
	}
	static void setup(int n, int pre, int d) {
		diameter=0;
		dfs(n,pre,d);
	}
	static void dfs(int n, int pre, int d) {
		for(int i : adj[n]) {
			if(i!= pre&&meet[i])dfs(i,n,d+1);
		}
		if(d>diameter){ 
			diameter = d;
			farthest = n; 
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		adj = new ArrayList[N]; 
		meet = new boolean[N];
		for(int i = 0; i<N; i++)adj[i]=new ArrayList<Integer>();
		for(int i = 1; i<M; i++)meet[readInt()]=true;
		int s = readInt();
		meet[s]=true;
		for(int i = 1; i<N; i++) {
			int u = readInt(), v = readInt();
			adj[u].add(v);
			adj[v].add(u);
		}
		meetup(s, -1);
		setup(s, -1, 0);
		setup(farthest, -1, 0);
		System.out.println(2*e-diameter);
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