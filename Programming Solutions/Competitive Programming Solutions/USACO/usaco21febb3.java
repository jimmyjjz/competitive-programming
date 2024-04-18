import java.util.*;
import java.io.*;
public class Fences {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		for(int i = 0; i<N; i++) {
			String input = readLine();
			int xOne = 0;
			int yOne = 0;
			int xTwo = 0;
			int yTwo = 0;
			int total = 0;
			for(int j = 0; j<input.length(); j++) {
				if(input.charAt(j) == 'E') {
					xTwo = xOne+1;
				}
				if(input.charAt(j) == 'S') {
					yTwo = yOne-1;
				}
				if(input.charAt(j) == 'W') {
					xTwo = xOne-1;
				}
				if(input.charAt(j) == 'N') {
					yTwo = yOne+1;
				}
				total = total + (xOne * yTwo)-(xTwo * yOne);
				xOne = xTwo;
				yOne = yTwo;
			}
			if(total > 0) {
				System.out.println("CCW");
			}
			else {
				System.out.println("CW");
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