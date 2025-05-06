import java.util.*;
import java.io.*;
public class Tavan{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), K = readInt(), X = readInt()-1;
		char[] s = readLine().toCharArray();
		int[] dex = new int[M];
		for(int i = M-1; i>=0; i--) {
			dex[i]=X%K;
			X=X/K;
		}
		int place = 0;
		for(char c : s) {
			if(c=='#') {
				char[] legal = readLine().toCharArray();
				Arrays.sort(legal);
				System.out.print(legal[dex[place++]]);
			}
			else System.out.print(c);
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