import java.util.*;
import java.io.*;
public class Dodgeball {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] incremented = new int[N+1];
		for(int i = 1; i<=N; i++) {
			incremented[i]+=incremented[i-1]+i;
		}
		long total = 0;
		int same = 1;
		char pre = next().toLowerCase().charAt(0);
		for(int i = 1; i<N; i++) {
			char c = next().toLowerCase().charAt(0);
			if(c==pre)same++;
			else{
				total+=incremented[same];
				same=1;
			}
			pre=c;
		}
		total+=incremented[same];
		System.out.println(total%1000000007);
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