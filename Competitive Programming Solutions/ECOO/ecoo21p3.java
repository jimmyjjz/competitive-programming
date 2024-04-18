import java.util.*;
import java.io.*;
public class QQ {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), K = readInt();
		int[][] board = new int[2][N];
		for(int i = 0; i<K; i++) {
			int a = readInt(), b = readInt()-1,c = readInt();
			if(board[1][b] < c) {
				board[1][b] = c;
				board[0][b] = a;
			}
		}
		for(int i = 0; i<N; i++) {
			if(board[0][i] == 0) {
				System.out.print("-1 ");
			}
			else {
				System.out.print(board[0][i]+" ");
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