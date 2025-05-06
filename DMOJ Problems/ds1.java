import java.util.*;
import java.io.*;
public class BinaryIndexedTreeTest{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class BIT{
		long tree[];
		int values[], len;
		public BIT(int[] arr) {
			len=arr.length+1;
			tree=new long[len];
			values=new int[len];
			for(int i = 1; i<len; i++)update(i,arr[i-1]);
		}
		public void update(int i, int v) {
			long change = v-values[i];
			for(int j = i; j<len; j+=j&-j)tree[j]+=change;
			values[i]=v;
		}
		public long query(int i) {
			long sum = 0;
			for(int j = i; j>0; j=j-(j&-j))sum+=tree[j];
			return sum;
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), arr[] = new int[N];;
		for(int i = 0; i<N; i++)arr[i]=readInt();
		BIT bit = new BIT(arr), fre = new BIT(new int[1000001]);
		for(int i = 1; i<=N; i++)fre.update(bit.values[i],fre.values[bit.values[i]]+1);
		for(int i = 0; i<M; i++) {
			String s = next();
			if(s.equals("C")) {
				int x = readInt(), v = readInt();
				fre.update(bit.values[x],fre.values[bit.values[x]]-1);
				bit.update(x,v);
				fre.update(v,fre.values[v]+1);
			}
			else if(s.equals("S")) {
				int l = readInt(), r = readInt();
				System.out.println(bit.query(r)-bit.query(l-1));
			}
			else {
				System.out.println(fre.query(readInt()));
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