import java.util.*;
import java.io.*;
public class Gates {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int G = readInt(), P = readInt();
		List<Integer> plot = new ArrayList<Integer>();
		for(int i = 1; i<=G; i++) {
			plot.add(i);
		}
		for(int i = 0; i<P; i++) {
		int dex = Collections.binarySearch(plot, readInt());
		if(dex == -1) {
			System.out.println(i);
			return;
		}
		else if(dex < 0) {
			plot.remove(Math.abs(dex)-2);
		}
		else {
			plot.remove(dex);
		}
		}
		System.out.println(P);
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