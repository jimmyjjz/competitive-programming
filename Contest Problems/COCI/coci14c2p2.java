import java.util.*;
import java.io.*;
public class Utrka {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		List<String> enter = new ArrayList<String>();
		List<String> done = new ArrayList<String>();
		for(int i = 0; i<N; i++) {
			enter.add(readLine());
		}
		for(int i = 1; i<N; i++) {
			done.add(readLine());
		}
		Collections.sort(enter);
		Collections.sort(done);
		for(int i = 0; i<N-1; i++) {
			if(!(enter.get(i).equals(done.get(i)))) {
				System.out.println(enter.get(i));
				return;
			}
		}
		System.out.println(enter.get(enter.size()-1));
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