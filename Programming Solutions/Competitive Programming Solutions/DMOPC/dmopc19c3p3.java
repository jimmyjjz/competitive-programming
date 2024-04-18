import java.util.*;
import java.io.*;
public class Majority{
	static class BIT{
		long tree[];
		int values[], len;
		public BIT(int length) {
			len=length+1;
			tree=new long[len];
			values=new int[len];
		}
		public void update(int i, int v) {
			for(int j = i; j<len; j+=j&-j)tree[j]+=v;
			values[i]+=v;
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
		int N = readInt(), n[] = new int[N], mid = 150001, shift = 150001;
		BIT fre = new BIT(300001);
		for(int i = 0; i<N; i++) {
			n[i]=readInt();
			mid+=n[i]==1?1:-1;
			fre.update(mid, 1);
		}
		long total = 0;
		for(int i = 0; i<N; i++) {
			total+=fre.query(300001)-fre.query(shift);
			shift+=n[i]==1?1:-1;
			fre.update(shift, -1);
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