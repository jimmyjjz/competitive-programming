import java.util.*;
import java.io.*;
public class Emerald {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), total = 0, biggest = 0;
		for(int i = 0; i<N; i++) {
			int in = readInt();
			if(in%2==0) {
				total+=in;
				if(total>biggest) {
					biggest = total;
				}
				continue;
			}
			total = 0;
		}
		System.out.println(biggest);
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