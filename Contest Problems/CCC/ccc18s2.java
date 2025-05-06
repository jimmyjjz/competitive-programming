import java.util.*;
import java.io.*;
public class Sunflowers{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), board[][] = new int[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)board[i][j]=readInt();
		}
		if(board[0][0]<board[0][1]&&board[0][0]<board[1][0]) {
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++)System.out.print(board[i][j]+" ");
				System.out.println();
			}
		}
		else if(board[0][N-1]<board[0][N-2]&&board[0][N-1]<board[1][N-1]) {
			for(int i = N-1; i>=0; i--) {
				for(int j = 0; j<N; j++)System.out.print(board[j][i]+" ");
				System.out.println();
			}
		}
		else if(board[N-1][N-1]<board[N-2][N-1]&&board[N-1][N-1]<board[N-1][N-2]) {
			for(int i = N-1; i>=0; i--) {
				for(int j = N-1; j>=0; j--)System.out.print(board[i][j]+" ");
				System.out.println();
			}
		}
		else {
			for(int i = 0; i<N; i++) {
				for(int j = N-1; j>=0; j--)System.out.print(board[j][i]+" ");
				System.out.println();
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