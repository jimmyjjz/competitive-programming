import java.util.*;
import java.io.*;
public class WormholeSort {
	static class edge{
		int x,y,w;
		public edge(int x, int y, int w) {
			this.x=x;
			this.y=y;
			this.w=w;
		}
	}
	static class SortbyWeight implements Comparator<edge>{
		public int compare(edge a, edge b) {
			return Integer.compare(a.w, b.w);
		}
	}
	public static int findrep(int[][] rep, int n) {
		while(rep[n][0]!=n)n=rep[n][0];
		return n;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt(), M = readInt();
	int[] cows = new int[N+1];
	for(int i = 1; i<=N; i++) {
		cows[i]=readInt();
	}
	Stack<edge> board = new Stack<edge>();
	for(int i = 0; i<M; i++) {
		board.push(new edge(readInt(), readInt(), readInt()));
	}
	Collections.sort(board, new SortbyWeight());
	int[][] rep = new int[N+1][2];
	for(int i = 1; i<=N; i++)rep[i][0]=i;
	int min = Integer.MAX_VALUE;
	boolean change = false;
	for(int i = 1; i<=N; i++) {
		while(findrep(rep,i)!=findrep(rep,cows[i])) {
			edge e = board.pop();
			int a = findrep(rep,e.x), b = findrep(rep,e.y);
			if(rep[a][1]>=rep[b][1]) {
				rep[a][1]++;
				rep[b][0]=a;
			}
			else {
				rep[b][1]++;
				rep[a][0]=b;
			}
			min = e.w;
			change = true;
		}
	}
	System.out.println((change)?min:"-1");
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