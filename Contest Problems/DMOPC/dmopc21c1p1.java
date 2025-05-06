import java.util.*;
import java.io.*;
public class PartialGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long duke = 0, alice = 0;
		for(int i = 0; i<N; i++) {
			long in = readLong();
			if(in%2==0) {
				duke+=in;
			}
			else {
				alice+=in+1;
				}
		}
		duke = duke/2;
		alice = alice/2;
		if(duke>alice) {
			System.out.println("Duke");
		}
		else {
			System.out.println("Alice");
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