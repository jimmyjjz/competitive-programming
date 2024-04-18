import java.io.*;
import java.util.*;
public class BadBunnies {
	public static adj[] tree =  new adj[200001];
	public static int closest = Integer.MAX_VALUE;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static int end;
	static class adj{
		public int LowA = Integer.MAX_VALUE, LowB = Integer.MAX_VALUE;
		public ArrayList <Integer> store = new ArrayList<Integer>();
		public int getA() {return LowA;}
		public void replaceA(int LowA) {this.LowA = LowA;}
		public void add (int i) {this.store.add(i);}
		public int get(int i) {return this.store.get(i);}
	}
	public static void dfs(int current, int dist) {
		int save = closest, direct = tree[current].LowB;
		closest = Math.min(closest, direct);
		if(current == end) {
			System.out.println(closest);
			System.exit(0);
		}
		int fixed = tree[current].store.size();
		for(int i = 0; i<fixed; i ++) {
			direct = tree[current].get(i);
			if(tree[direct].getA()>dist+1) {
				tree[direct].replaceA(dist+1);
				dfs(direct,dist+1);
			}
		}
		closest = save;
	}
	public static void pedal(int current, int dist) {
		tree[current].LowB = Math.min(tree[current].LowB, dist);
		int fixed = tree[current].store.size();
		for(int i = 0; i<fixed; i++) {
			int direct = tree[current].get(i);
			if(tree[direct].LowB>dist+1){
				pedal(direct,dist+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
			int N = readInt(),R = readInt();
			for(int i = 0; i<N; i++) {
				tree[i] = new adj();
			}
			for(int i = 1; i<N; i++) {
				int a = readInt()-1, b = readInt()-1;
				tree[a].add(b);
				tree[b].add(a);
			}
			for(int i = 0; i<R; i++) {
				int save = readInt()-1;
				if(tree[save].LowB!=0) {
				pedal(save,0);
				}
			}
			end = readInt()-1;
			int start = readInt()-1;
			tree[start].replaceA(0);
			dfs(start, 0);
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
}