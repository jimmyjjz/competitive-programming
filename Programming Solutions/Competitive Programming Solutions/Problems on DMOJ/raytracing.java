import java.util.*;
import java.io.*;
public class RayTracing{
	static class BIT{
		int tree[];
		int len;
		public BIT(int length) {
			len=length+1;
			tree=new int[len];
		}
		public void update(int i, int v) {
			for(int j = i; j<len; j+=j&-j)tree[j]+=v;
		}
		public long query(int i) {
			long sum = 0;
			for(int j = i; j>0; j=j-(j&-j))sum+=tree[j];
			return sum;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), trees[] = new int[N+1];
		BIT[] bit = new BIT[N+1];
		for(int i = 1; i<=N; i++)bit[i]=new BIT(N+1);
		for(int i = 1; i<=N; i++) {
			int in = readInt()+1;
			trees[i]=in;
			for(int j = i; j<=N; j+=j&-j)bit[j].update(in,1);
		}
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int op = readInt();
			if(op==1) {
				int x = readInt()+1, y = readInt()+1, a = readInt()+1, b = readInt()+1, sum = 0;
				for(int j = y; j>0; j-=j&-j)sum+=bit[j].query(b)-bit[j].query(a-1);
				for(int j = x-1; j>0; j-=j&-j)sum-=bit[j].query(b)-bit[j].query(a-1);
				System.out.println(sum);
			}
			else {
				int x = readInt()+1, h = readInt()+1;
				for(int j = x; j<=N; j+=j&-j)bit[j].update(trees[x],-1);
				for(int j = x; j<=N; j+=j&-j)bit[j].update(h,1);
				trees[x]=h;
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