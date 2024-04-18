import java.util.*;
import java.io.*;
public class FoxHole {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int H = readInt(), W = readInt(), N = readInt();
			char[][] board = new char[H+1][W];
			for(int j = 1; j<=H; j++) {
				String s = readLine();
				for(int k = 0; k<W; k++) {
					board[j][k]=s.charAt(k);
					//System.out.print(s.charAt(k));
				}
				//System.out.println();
			}
			int x = 0, y = 0, cnt = 0;
			for(int j = 0; j<N; j++) {
				char cmd = readCharacter();
				try {if(cmd=='R'&&board[x][y+1]!='S')y++;}catch(Exception e) {}
				try {if(cmd=='L'&&board[x][y-1]!='S')y--;}catch(Exception e) {}
				try {if(cmd=='D'&&board[x+1][y]!='S')x++;}catch(Exception e) {}
				try {
				if(board[x][y]=='T') {
					board[x][y]='E';
					cnt++;
				}
				}
				catch(Exception e) {}
				try {while(board[x+1][y]=='E')x++;}catch(Exception e) {}
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