import java.util.*;
import java.io.*;
public class ChikaGrids{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		int[][] board = new int[N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++)board[i][j]=readInt();
		}
		int cap = Integer.MAX_VALUE;
		for(int j = M-1; j>=0; j--) {
			if(board[N-1][j]==0) {
				board[N-1][j]=cap--;
				if(board[N-1][j]<1) {
					System.out.println("-1");
					return;
				}
			}
			else {
				if(cap<1||board[N-1][j]>cap) {
					System.out.println("-1");
					return;
				}
				cap=board[N-1][j]-1;
			}
		}
		for(int i = N-2; i>=0; i--) {
			for(int j = M-1; j>=0; j--) {
				if(board[i][j]==0) {
					if(j==M-1) {
						board[i][j]=board[i+1][j]-1;
						if(board[i][j]<1) {
							System.out.println("-1");
							return;
						}
					}
					else {
						board[i][j]=Math.min(board[i+1][j],board[i][j+1])-1;
						if(board[i][j]<1) {
							System.out.println("-1");
							return;
						}
					}
				}
				else if(j==M-1) {
					if(board[i][j]>=board[i+1][j]) {
					System.out.println("-1");
					return;
					}
				}
				else if(board[i][j]>=board[i+1][j]||board[i][j]>=board[i][j+1]) {
					System.out.println("-1");
					return;
				}
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++)System.out.print(board[i][j]+" ");
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