import java.util.*;
import java.io.*;
//code based off bruce's solution with some changes
public class Vudu2{
	static class BIT{
		long tree[];
		int len;
		public BIT(int length) {
			len=length+1;
			tree=new long[len];
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
	static int bs(long a[], long key){
		int lo = 0, hi = a.length, len = hi - lo;
		while( len > 0 ){
			int half = len/2, mid = lo + half;
			if(a[mid] < key) { lo = mid+1; len = len - half - 1; }
			else len = half;
		}
		return lo;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long [] ai = new long [N], rep = new long [N];
		BIT bit = new BIT(N);
		for(int i = 0; i < N; i++) ai[i] = readInt();
		int P = readInt();
		for(int i = 0; i < N; i++)ai[i] -= P;
		rep[0] = ai[0];
		for(int i = 1; i < N; i++) {
			ai[i] += ai[i - 1];
			rep[i] = ai[i];
		}	
		Arrays.sort(rep); 	
		long out = 0;
		for(int i = 0; i < N; i++) {
			int rank = bs(rep, ai[i])+1;
			out += bit.query(rank); 
			bit.update(rank,1);
			if(ai[i]>=0)out++;
		}
		System.out.println(out);
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