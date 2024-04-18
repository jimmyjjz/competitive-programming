import java.util.*;
import java.io.*;
public class NumOfFactors {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<5; i++) {
			int N = readInt(), cnt = 0, ori = N;
			for(int j = 2; j<ori; j++) {
				if(N == 0) {
					break;
				}
				if(N%j==0) {
					N/=j;
					cnt++;
					j--;
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