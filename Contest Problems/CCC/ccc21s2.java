import java.util.*;
import java.io.*;
public class ModernArt {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int M = readInt(), N = readInt(), K = readInt();
		Map<Integer, Boolean> R = new HashMap<Integer,Boolean>();
		Map<Integer, Boolean> C = new HashMap<Integer,Boolean>();
		for(int i = 0; i<K; i++) {
			String s = next();
			int n = readInt();
			if(s.equals("R")) {
				if(R.get(n)==null||!R.get(n))R.put(n,true);
				else R.remove(n);
			}
			else {
				if(C.get(n)==null||!C.get(n))C.put(n,true);
				else C.remove(n);
			}
		}
		System.out.println((R.size()*(N-C.size()))+(C.size()*(M-R.size())));

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