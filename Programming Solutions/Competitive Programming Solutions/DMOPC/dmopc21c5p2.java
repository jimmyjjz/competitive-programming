import java.util.*;
import java.io.*;
public class PermutationsAndPrime2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		if(N==1) {
			System.out.println("1");
			return;
		}
		if(N==2) {
			System.out.println("-1");
			return;
		}
		if(N==3) {
			System.out.println("1 3 2");
			return;
		}
		if(N==4) {
			System.out.println("4 2 3 1");
			return;
		}
		System.out.print("4 2 3 1 ");
		for(int i = 5; i<=N; i++)System.out.print((i+1>N)?i:i+" ");
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