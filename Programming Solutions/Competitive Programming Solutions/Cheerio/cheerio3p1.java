import java.util.*;
import java.io.*;
public class WetFloor{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		char[][] board = new char[N][M];
		for(int i = 0; i<N; i++)Arrays.fill(board[i], '.');
		for(int i = 0; i<N; i++) {
			String s = readLine();
			for(int j = 0; j<M; j++) {
				if(s.charAt(j)=='W') {
					board[i][j]='W';
					try{if(board[i+1][j]!='W')board[i+1][j]='C';}catch(Exception e) {}
					try{if(board[i][j+1]!='W')board[i][j+1]='C';}catch(Exception e) {}
					try{if(board[i-1][j]!='W')board[i-1][j]='C';}catch(Exception e) {}
					try{if(board[i][j-1]!='W')board[i][j-1]='C';}catch(Exception e) {}
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++)System.out.print(board[i][j]);
			System.out.println();
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