import java.util.*;
import java.io.*;
public class ComparingArrays{
	static long pow[];
	static class BIT{
		long tree[], values[];
		int len;
		public BIT(int length) {
			len=length+1;
			tree=new long[len];
			values=new long[len];
		}
		public void update(int i, long v) {
			long change = v-values[i];
			for(int j = i; j<len; j+=j&-j)tree[j]+=change;
			values[i]=v;
		}
		public long query(int i) {
			long sum = 0;
			for(int j = i; j>0; j=j-(j&-j))sum=(sum+tree[j])%1000000007;
			return sum;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		pow = new long[N+1];
		BIT bit = new BIT(N);
		pow[1]=1;
		bit.update(1,readLong());
		for(int i = 2; i<=N; i++) {
			pow[i]=(pow[i-1]*50331653)%1000000007;
			bit.update(i,(readLong()*pow[i])%1000000007);
		}
		for(int i = 0; i<Q; i++) {
			int op = readInt();
			if(op==1) {
				int l1 = readInt(), r1 = readInt(), l2 = readInt(), r2 = readInt();
				System.out.println((bit.query(r1)-bit.query(l1-1)+1000000007)%1000000007*pow[l2]%1000000007==(bit.query(r2)-bit.query(l2-1)+1000000007)%1000000007*pow[l1]%1000000007?"1":"0");
			}
			else {
				int idx = readInt();
				bit.update(idx,(readLong()*pow[idx])%1000000007);
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