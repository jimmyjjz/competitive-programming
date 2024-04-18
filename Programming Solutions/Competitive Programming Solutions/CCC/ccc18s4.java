import java.util.*;
import java.io.*;
public class BalancedTrees {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Map<Integer,Long> m = new HashMap<Integer,Long>();
	public static long r(int cur) {
		if(m.get(cur)!=null)return m.get(cur);
		long sum = 0;
		for(int i = 2; i<=cur; i=(cur/(cur/i))+1)sum+=r(cur/i)*(cur/(cur/i)+1-i);
		m.put(cur, sum);
		return sum;
	}
	public static void main(String[] args) throws IOException{
		m.put(1,1L);
		System.out.println(r(readInt()));
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