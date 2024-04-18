import java.util.*;
import java.io.*;
public class DrHenriandLabData{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class question{
		int l,r,k,i;
		public question(int l, int r, int k, int i) {
			this.l=l;
			this.r=r;
			this.k=k;
			this.i=i;
		}
	}
	static class BIT{
		long tree[]; 
		int len, values[];
		public BIT(int[] arr) {
			len=arr.length+1;
			tree=new long[len];
			values=new int[len];
			for(int i = 1; i<len; i++)update(i,arr[i-1]);
		}
		public void update(int i, int v) {
			int change = v-values[i];
			for(int j = i; j<len; j+=j&-j)tree[j]+=change;
			values[i]=v;
		}
		public long query(int i) {
			long sum = 0;
			for(int j = i; j>0; j=j-(j&-j))sum+=tree[j];
			return sum;
		}
	}
	static class SortbyK implements Comparator<question>{
		public int compare(question a, question b) {
			return Integer.compare(a.k,b.k);
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt(), nums[] = new int[N];
		Map<Integer,List<Integer>> link = new HashMap<Integer,List<Integer>>();
		Set<Integer> revdupe = new HashSet<Integer>();
		for(int i = 0; i<N; i++) {
			nums[i]=readInt();
			if(link.get(nums[i])==null)link.put(nums[i], new ArrayList<Integer>());
			link.get(nums[i]).add(i);
			revdupe.add(nums[i]);
		}
		LinkedList<Integer> sortednums = new LinkedList<Integer>(revdupe);
		Collections.sort(sortednums);
		List<question> qs = new ArrayList<question>();
		for(int i = 0; i<Q; i++)qs.add(new question(readInt(),readInt(),readInt(),i));
		Collections.sort(qs, new SortbyK());
		long[] output = new long[Q];
		BIT bit = new BIT(nums);
		for(int i = 0; i<Q; i++) {
			while(!sortednums.isEmpty()&&sortednums.peekFirst()<qs.get(i).k) {
				for(int v : link.get(sortednums.pollFirst()))bit.update(v+1,-bit.values[v+1]);
			}
			output[qs.get(i).i]=bit.query(qs.get(i).r)-bit.query(qs.get(i).l-1);
		}
		for(long l : output)System.out.println(l);
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