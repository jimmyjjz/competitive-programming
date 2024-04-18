import java.util.*;
import java.io.*;
public class BovineMovie {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<Long,Integer> all = new HashMap<Long,Integer>();
		LinkedList<Long> active = new LinkedList<Long>();
		//find top 2 most poplular widths
		// and then put actor count
		int N = readInt();
		long one = 0;
		long two = 0;
		long now = 0;
		long save = 0;
		for(int i = 0; i<N; i++) {
			now = readLong();
			if(all.get(now) != null) {
				all.put(now, all.get(now)+1);
			}
			else {
				all.put(now, 1);
				active.add(now);
			}
		}
		while(!active.isEmpty()) {
			now = all.get(active.remove(0));
			if(now > two) {
				two = now;
			}
			if(one < two) {
				save = two;
				two = one;
				one = save;
			}
		}
		System.out.println(two+one);
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