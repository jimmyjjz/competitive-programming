import java.util.*;
import java.io.*;
public class UnnescessaryTrashPush {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt(), K = readInt(), cnt = 0, build = 0;
			for(int j = 0; j<N; j++) {
				build+=readInt();
				if(build >= K) {
					cnt++;
					build=0;
				}
			}
			System.out.println(cnt);
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