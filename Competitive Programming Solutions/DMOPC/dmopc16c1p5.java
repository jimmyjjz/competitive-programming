import java.util.*;
import java.io.*;
public class BloodTubes{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class BIT{
		long tree[];
		int values[], len;
		public BIT(Deque<Integer> dq) {
			len=dq.size()+1;
			tree=new long[len];
			values=new int[len];
			for(int i = 1; i<len; i++)update(dq.peekFirst(),values[dq.pollFirst()]+1);
		}
		public BIT(int[] arr) {
			len=arr.length+1;
			tree=new long[len];
			values=new int[len];
		}
		public void update(int i, int v) {
			long change = v-values[i];
			for(int j = i; j<len; j+=j&-j)tree[j]+=change;
			values[i]=v;
		}
		public int query(int i) {
			int sum = 0;
			for(int j = i; j>0; j=j-(j&-j))sum+=tree[j];
			return sum;
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long inversion = 0;
		Deque<Integer> dq = new LinkedList<Integer>();
		BIT fre2 = new BIT(new int[N]);
		for(int i = 0; i<N; i++) {
			int in = readInt(), query = fre2.query(in);
			if(query>i-query)dq.addLast(in);
			else dq.addFirst(in);
			fre2.update(in, 1);
		}
		BIT fre = new BIT(new LinkedList<Integer>(dq));
//		System.out.println(dq);
		for(int i = 1; i<=N; i++) {
			fre.update(dq.peekFirst(),fre.values[dq.peekFirst()]-1);
			inversion+=fre.query(dq.pollFirst());
		}
		System.out.println(inversion);
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