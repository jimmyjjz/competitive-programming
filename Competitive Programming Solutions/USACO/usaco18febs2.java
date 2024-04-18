import java.util.*;
import java.io.*;
public class SnowBoots{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class seg{
		int in[], segtree[];
		seg(int[] in){
			this.in=in;
			segtree=new int[in.length*4];
			build(1,0,in.length-1);
		}
		void build(int cur, int l, int r) {
		    if(l==r)segtree[cur]=in[l];
		    else {
		        int m = (l+r)/2;
		        build(cur*2, l, m);
		        build(cur*2+1, m+1, r);
		        segtree[cur]=Math.min(segtree[cur*2],segtree[cur*2+1]);
		    }
		}
		int query(int cur, int ml, int mr, int l, int r) {
		    if(l>r)return Integer.MAX_VALUE;
		    if(l==ml&&r==mr)return segtree[cur];
		    int m = (ml+mr)/2;
		    return Math.min(query(cur*2, ml, m, l, Math.min(r,m)),query(cur*2+1, m+1, mr, Math.max(l,m+1), r));
		}
		void update(int cur, int ml, int mr, int pos, int v) {
		    if(ml==mr)segtree[cur]=v;
		    else {
		        int m = (ml+mr)/2;
		        if(pos<=m)update(cur*2, ml, m, pos, v);
		        else update(cur*2+1, m+1, mr, pos, v);
		        segtree[cur]=Math.min(segtree[cur*2],segtree[cur*2+1]);
		    }
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), B = readInt(), snow[] = new int[N], fillMAX[] = new int[N+1];
		Arrays.fill(fillMAX, Integer.MAX_VALUE);
		seg segtree = new seg(fillMAX);
		boolean[] reachable = new boolean[N];
		reachable[0]=true;
		segtree.update(1,0,N-1,0,snow[0]);
		for(int i = 0; i<N; i++)snow[i]=readInt();
		for(int i = 0; i<B; i++) {
			int t = readInt(), d = readInt();
			for(int j = 0; j<N; j++) {
				if(segtree.query(1,0,N-1,Math.max(j-d,0),j)<=t&&snow[j]<=t) {
					segtree.update(1,0,N-1,j,snow[j]);
					reachable[j]=true;
				}
			}
		if(reachable[N-1]) {
			System.out.println(i);
			break;
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