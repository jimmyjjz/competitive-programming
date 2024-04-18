import java.util.*;
import java.io.*;
public class Switches {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), cnt = 0;
		String in = readLine();
		boolean mode = false;
		for(int i = N-1; i>=0; i--) {
			if(mode) {
				if(in.charAt(i) != '1') {
					mode = false;
					cnt++;
				}
			}
			else {
				if(in.charAt(i) != '0') {
					mode = true;
					cnt++;
				}
			}
		}
		System.out.println(cnt);
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