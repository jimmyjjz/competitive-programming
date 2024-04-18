import java.util.*;
import java.io.*;
public class Waterpark {
	static class pair{
		int x,y;
		public pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static class Sortbyval implements Comparator<pair>{
		public int compare(pair a, pair b) {
			return Integer.compare(a.x,b.x);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] ways = new int[10000];
		ways[1]=1;
		List<pair> sort = new ArrayList<pair>();
		int a = readInt(), b = readInt();
		while(a!=0&&b!=0) {
			sort.add(new pair(a,b));
			a = readInt();
			b = readInt();
		}
		Collections.sort(sort, new Sortbyval());
		for(pair p : sort) {
			ways[p.y]+=ways[p.x];
		}
		//System.out.println(Arrays.toString(ways));
		System.out.println(ways[N]);
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