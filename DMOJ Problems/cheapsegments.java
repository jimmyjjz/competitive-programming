//idea from bruce's code
import java.util.*;
import java.io.*;
public class AllensSegments {
	static class edge {
		int l, r, v, dex;
		edge(int l, int r, int v, int dex) {
			this.l = l;
			this.r = r;
			this.v = v;
			this.dex = dex;
		}
	}
	static int N, Q, logsize, dep[], dex[], val[], ances[][];
	static List<Integer> adj[];
	static int LCA(int u, int v) {
		if(dep[u]<dep[v]) {
			int temp=u;
			u=v;
			v=temp;
		}
		for(int k = logsize-1; k>=0; k--) {
			if(ances[k][u]==-1)continue;
			if(dep[ances[k][u]]>=dep[v])u=ances[k][u];
		}
		if(u==v)return u;
		for(int k = logsize-1; k>=0; k--) {
			if(ances[k][u]!=ances[k][v]) {
				u=ances[k][u];
				v=ances[k][v];
			}
		}
		return ances[0][u];
	}
	static void dfs(int u, int p) {
		ances[0][u]=p;
		for(int k = 1; k<logsize; k++)if(ances[k-1][u]!=-1)ances[k][u]=ances[k-1][ances[k-1][u]];
		if(p!=-1) {
			if(val[u]<=val[dex[p]])dex[u]=u;
			else dex[u]=dex[p];
		}
		for(int v : adj[u]) {
			dep[v]=dep[u]+1;
			dfs(v, u);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(), left[] = new int[N+1], right[] = new int[N+1];
		List<Integer> li = new ArrayList<Integer>();
		adj = new ArrayList[N+1];
		logsize=(int)(double)(Math.log(N+1)/(double)Math.log(2)+1);
		dep = new int[N+1];
		dex = new int[N+1];
		val = new int[N+1];
		ances = new int[logsize][N+1];
		for(int i = 0; i<=N; i++)adj[i]=new ArrayList<Integer>();
		for(int i = 0; i<ances.length; i++)Arrays.fill(ances[i], -1);
		for(int i = 1; i<=N; i++) {
			left[i]=readInt();
			right[i]=readInt();
			val[i]=readInt();
			li.add(i);
		}
		Collections.sort(li, (a, b)->Integer.compare(left[a], left[b]));
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(0);
		right[0]=Integer.MAX_VALUE;
		val[0]=Integer.MAX_VALUE;
		for(int v : li) {
			while(right[v]>right[stk.peek()])stk.pop();
			adj[stk.peek()].add(v);
			stk.push(v);
		}
		dfs(0, -1);
		Q = readInt();
		for(int i = 1, u, v; i<=Q; i++) {
			u=readInt();
			v=readInt();
			int root = LCA(u, v);
			if(root==v||root==u)root=ances[0][root];
			System.out.println(root==0?-1:dex[root]);
		}
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}