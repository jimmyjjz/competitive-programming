import java.util.*;
import java.io.*;
public class bobballs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Set<Long> order = new HashSet<Long>();
		long N = readLong();
		if(N==1) {
			System.out.println(1);
			return;
		}
		for(long i = 1; i<Math.sqrt(N)+1; i++) {
			if(N%i==0) {
				order.add(i);
				order.add(N/i);
			}
		}
		List<Long> result = new ArrayList<Long>(order);
		Collections.sort(result);
		int fixed = result.size();
		for(int i = 0; i<fixed; i++) {
			System.out.println(result.get(i));
		}
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