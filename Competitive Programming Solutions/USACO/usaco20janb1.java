import java.util.*;
import java.io.*;
public class processor {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		StringTokenizer split = new StringTokenizer(readLine()," ");
		int mass = 0;
		for(int i = 0; i<N; i++) {
			String current = split.nextToken();
			mass+=current.length();
			if(mass>K) {
				System.out.println();
				System.out.print(current);
				mass = current.length();
			}
			else if(i==0) {
				System.out.print(current);
			}
			else {
				System.out.print(" "+current);
			}
		}
		System.out.println();
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