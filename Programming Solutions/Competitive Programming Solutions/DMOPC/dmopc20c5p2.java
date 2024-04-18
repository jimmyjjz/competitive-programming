import java.util.*;
import java.io.*;
public class line {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<String> keep = new ArrayList<String>();
		double N = readInt();
		double M = readInt();
		int count = 0;
		//get slope with is y2/x2 and use as plotting tool
		for(int i = 1; i<=M; i++) {
			for(double j = Math.floor(N*(i-1)/M)+1; j<=Math.ceil(N*i/M);j++) {
				keep.add((int) j+" "+i);
				count++;
			}
		}
		System.out.println(count);
		for(int i = 0; i<keep.size(); i++) {
			System.out.println(keep.get(i));
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