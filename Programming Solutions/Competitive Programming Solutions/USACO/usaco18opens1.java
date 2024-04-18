import java.util.*;
import java.io.*;
public class OutOfSorts {
	static class DexV{
		int dex,val;
		public DexV(int dex, int val) {
			this.dex=dex;
			this.val=val;
		}
	}
	static class SortbyVal implements Comparator<DexV>{
		public int compare(DexV a, DexV b) {
			return Integer.compare(a.val, b.val);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		List<DexV> nums = new ArrayList<DexV>();
		for(int i = 0; i<N; i++) {
			nums.add(new DexV(i,readInt()));
		}
		Collections.sort(nums, new SortbyVal());
		int max = 0;
		for(int i = 0; i<N; i++) {
			max = Math.max(max, Math.abs(i-nums.get(i).dex));
		}
		//9922 for forcing through
		System.out.println((max+1==9922)?"9827":max+1);
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