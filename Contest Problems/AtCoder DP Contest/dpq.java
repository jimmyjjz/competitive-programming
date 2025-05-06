import java.util.*;
import java.io.*;
public class Flowers{
	static class BIT{
		long tree[];
		int len;
		public BIT(int length) {
			len=length+1;
			tree=new long[len];
		}
		public void update(int i, long v) {
			for(int j = i; j<len; j+=j&-j)tree[j]=Math.max(tree[j],v);
		}
		public long query(int i) {
			long max = 0;
			for(int j = i; j>0; j=j-(j&-j))max=Math.max(max, tree[j]);
			return max;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), vals[][] = new int[N][2];
		for(int i = 0; i<N; i++)vals[i][0]=readInt();
		for(int i = 0; i<N; i++)vals[i][1]=readInt();
		BIT bit = new BIT(N+1);
		for(int i = 0; i<N; i++)bit.update(vals[i][0],bit.query(vals[i][0]-1)+vals[i][1]);
		System.out.println(bit.query(N));
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