import java.util.*;
import java.io.*;
public class TheCakeisaDessert{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), K = readInt();
		long cake[][] = new long[N+1][M+1];
		for(int i = 0; i<K; i++) {
			int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
			try {cake[r1][c1]++;}catch(Exception e) {}
			try {cake[r2+1][c2+1]++;}catch(Exception e) {}
			try {cake[r1][c2+1]--;}catch(Exception e) {}
			try {cake[r2+1][c1]--;}catch(Exception e) {}
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++)cake[i][j]+=cake[i-1][j]+cake[i][j-1]-cake[i-1][j-1];
		}
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=M; j++)cake[i][j]+=cake[i-1][j]+cake[i][j-1]-cake[i-1][j-1];
		}
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
			System.out.println(cake[r2][c2]-cake[r1-1][c2]-cake[r2][c1-1]+cake[r1-1][c1-1]);
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