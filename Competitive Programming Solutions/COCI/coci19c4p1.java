import java.util.*;
import java.io.*;
public class Podstarimkrovovima{
	static class glass{
		int v,i;
		public glass(int v, int i) {
			this.v=v;
			this.i=i;
		}
	}
	static class SortbyV implements Comparator<glass>{
		public int compare(glass a, glass b) {
			return -Integer.compare(a.v,b.v);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long tot = 0;
		List<glass> glasses = new ArrayList<glass>();
		for(int i = 0; i<N; i++) {
			tot+=readInt();
			glasses.add(new glass(readInt(), i));
		}
		Collections.sort(glasses, new SortbyV());
		int[] output = new int[N];
		for(glass g : glasses) {
			if(tot>0) {
				output[g.i]=(int)Math.min(tot, g.v);
				tot-=Math.min(tot, g.v);
				N--;
			}
		}
		System.out.println(N);
		for(int i : output)System.out.print(i+" ");
		System.out.println();
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