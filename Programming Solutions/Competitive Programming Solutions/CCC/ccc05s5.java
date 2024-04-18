import java.util.*;
import java.io.*;
public class PinballRanking{
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
		public BIT(int length) {
			len=length+1;
			tree=new long[len];
			values=new int[len];
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
		int t = readInt();
		long[] ordered = new long[t];
		Set<Long> dupe = new HashSet<Long>();
		for(int i = 0; i<t; i++) {
			long l = readLong();
			ordered[i]=l;
			dupe.add(l);
		}
		List<Long> sorted = new ArrayList<Long>(dupe);
		Collections.sort(sorted);
		Map<Long,Integer> corres = new HashMap<Long,Integer>();
		int size = sorted.size();
		double total = 0;
		for(int i = 0; i<size; i++)corres.put(sorted.get(i),i+1);
		int corresSize = corres.size();
		BIT bit = new BIT(corresSize);
		for(int i = 0; i<t; i++) {
			bit.update(corres.get(ordered[i]),bit.values[corres.get(ordered[i])]+1);
			total+=bit.query(corresSize)-bit.query(corres.get(ordered[i]))+1;
		}
		System.out.println(total/t);
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