import java.util.*;
import java.io.*;
public class DNA {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String in = readLine();
		for(int i = 0; i<in.length(); i++) {
			if(in.charAt(i) == 'A') {
				if(i != 0) {
					if(in.charAt(i-1) == 'A') {
						System.out.print(' ');
					}
				}
				System.out.print('A');
			}
			else {
					if(i != 0) {
						if(in.charAt(i-1) == 'A') {
						System.out.print(in.charAt(i));
						continue;
						}
					}
						System.out.print(' ');
						System.out.print(in.charAt(i));
			}
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