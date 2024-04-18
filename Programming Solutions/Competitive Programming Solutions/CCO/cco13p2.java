import java.util.*;
import java.io.*;
public class CCOTourney{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class keep{
		int i,v;
		keep(int i, int v){
			this.i=i;
			this.v=v;
		}
	}
	static keep keepMax(keep a, keep b) {return a.v>b.v?a:b;}
	static class seg{
		int in[];
		keep segtree[];
		seg(int[] in){
			this.in=in;
			segtree=new keep[in.length*4];
			build(1,0,in.length-1);
		}
		void build(int cur, int l, int r) {
		    if(l==r)segtree[cur]=new keep(l,in[l]);
		    else {
		        int m = (l+r)/2;
		        build(cur*2, l, m);
		        build(cur*2+1, m+1, r);
		        segtree[cur]=keepMax(segtree[cur*2],segtree[cur*2+1]);
		    }
		}
		keep query(int cur, int ml, int mr, int l, int r) {
		    if(l>r)return new keep(-1,-1);
		    if(l==ml&&r==mr)return segtree[cur];
		    int m = (ml+mr)/2;
		    return keepMax(query(cur*2, ml, m, l, Math.min(r,m)),query(cur*2+1, m+1, mr, Math.max(l,m+1), r));
		}
		void update(int cur, int ml, int mr, int pos, int v) {
		    if(ml==mr)segtree[cur]=new keep(pos,v);
		    else {
		        int m = (ml+mr)/2;
		        if(pos<=m)update(cur*2, ml, m, pos, v);
		        else update(cur*2+1, m+1, mr, pos, v);
		        segtree[cur]=keepMax(segtree[cur*2],segtree[cur*2+1]);
		    }
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), size = 1<<N, skill[] = new int[size];
		for(int i = 0; i<size; i++)skill[i]=readInt();
		seg segtree = new seg(skill);
		for(int i = 0; i<M; i++) {
			String s = next();
			if(s.equals("R"))segtree.update(1,0,size-1,readInt()-1, readInt());
			else if(s.equals("W"))System.out.println(segtree.query(1,0,size-1,0,size-1).i+1);
			else {
				int dex = readInt()-1, cnt = 0;
				for(int j = 1; j<=N; j++) {
					int section = dex/(1<<j);
					if(dex==segtree.query(1,0,size-1,(1<<j)*section,(1<<j)*(section+1)-1).i)cnt++;
					else break;
				}
				System.out.println(cnt);
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