import java.util.*;
import java.io.*;
public class SelectiveCutting{
	static class question{
		int a,b,q,i;
		public question(int a, int b, int q, int i) {
			this.a=a;
			this.b=b;
			this.q=q;
			this.i=i;
		}
	}
	static class SortbyQ implements Comparator<question>{
		public int compare(question a, question b) {
			return Integer.compare(a.q,b.q);
		}
	}
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
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), trees[] = new int[N];
		Set<Integer> predupe = new HashSet<Integer>();
		Map<Integer,List<Integer>> link = new HashMap<Integer,List<Integer>>();
		for(int i = 0; i<N; i++) {
			int in = readInt();
			if(link.get(in)==null)link.put(in,new ArrayList<Integer>());
			link.get(in).add(i+1);
			trees[i]=in;
			predupe.add(in);
		}
		BIT bit = new BIT(trees);
		LinkedList<Integer> li = new LinkedList<Integer>(predupe);
		Collections.sort(li);
		List<question> qs = new ArrayList<question>();
		int Q = readInt();
		for(int i = 0; i<Q; i++)qs.add(new question(readInt()+1, readInt()+1, readInt(), i));
		Collections.sort(qs, new SortbyQ());
		long[] output = new long[Q];
		for(int i = 0; i<Q; i++) {
			while(!li.isEmpty()&&li.peekFirst()<qs.get(i).q) {
				for(int j : link.get(li.pollFirst()))bit.update(j,0);
			}
			output[qs.get(i).i]=bit.query(qs.get(i).b)-bit.query(qs.get(i).a-1);
		}
		for(long i : output)System.out.println(i);
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