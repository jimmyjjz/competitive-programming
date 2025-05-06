import java.util.*;
import java.io.*;
public class Segment{
	static class pair{
		int l,r;
		public pair(int l, int r) {
			this.l=l;
			this.r=r;
		}
	}
	static class Sortbyl implements Comparator<pair>{
		public int compare(pair a, pair b) {
			return Integer.compare(a.l,b.l);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), dp[] = new int[1000001];
		List<pair> seg = new ArrayList<pair>();
		for(int i = 0; i<N; i++)seg.add(new pair(readInt(), readInt()));
		Collections.sort(seg, new Sortbyl());
		int cur = 0;
		for(pair p : seg) {
			for(int i = cur; i<=p.l; i++) {
				if(i==0)continue;
				dp[i]=Math.max(dp[i],dp[i-1]);
			}
			cur=p.l;
			dp[p.r]=Math.max(dp[p.r],dp[p.l]+1);
		}
		int max = 0;
		for(int i = 0; i<=1000000; i++)max=Math.max(max, dp[i]);
		System.out.println(max);
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