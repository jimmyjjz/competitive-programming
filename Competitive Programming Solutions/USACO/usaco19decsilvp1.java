import java.util.*;
import java.io.*;
public class MooBuzz {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		long N = readLong();
		long save = N%16;
		if(save == 0) {
			System.out.println((((N-(N%16))/16)*30));
			return;
		}
		for(int i = 1; i<=100; i++) {
			if(i%3!=0&&i%5!=0) {
				save--;
				if(save<=0) {
					System.out.println((((N-(N%16))/16)*30)+i);
					return;
				}
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