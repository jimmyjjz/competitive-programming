import java.util.*;
import java.io.*;
public class Deathstar{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[][] board = new int[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)board[i][j]=readInt();
		}
		for(int i = 0; i<N; i++) {
			int num = 0;
			for(int j = 0; j<N; j++)num|=board[i][j];
			System.out.print(num+" ");
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