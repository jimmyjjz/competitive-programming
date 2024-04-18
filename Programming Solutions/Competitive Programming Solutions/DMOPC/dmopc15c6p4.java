import java.util.*;
import java.io.*;
public class LineGraph {
	static class edge{
		int x,y,w;
		public edge(int x,int y, int w) {
			this.x=x;
			this.y=y;
			this.w=w;
		}
		public void print() {
			System.out.println(x+" "+y+" "+w);
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
		int N = readInt(), K = readInt();
		List<edge> branch = new ArrayList<edge>();
		for(int i = 1; i<N; i++) branch.add(new edge(i,i+1,readInt()));
		for(int i = 1; i+K<=N; i++)branch.add(new edge(i,i+K,0));
		Collections.sort(branch, new SortbyWeight());
		int[][] rep = new int[N+1][2];
		for(int i = 1; i<=N; i++) rep[i][0]=i;
		int total = 0;
		for(edge e : branch) {
			int x = findrep(rep,e.x), y = findrep(rep,e.y);
			if(x==y)continue;
			total+=e.w;
			if(rep[x][1]>=rep[y][1]) {
				rep[x][1]++;
				rep[y][0]=x;
			}
			else {
				rep[y][1]++;
				rep[x][0]=y;
			}
		}
		System.out.println(total);
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