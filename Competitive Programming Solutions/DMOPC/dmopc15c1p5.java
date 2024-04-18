import java.util.*;
import java.io.*;
public class LeileiAndDragonScales{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int W = readInt(), H = readInt(), tolerance = readInt(), board[][] = new int[H+1][W+1], max = 0;
		for(int i = 1; i<=H; i++) {
			for(int j = 1; j<=W; j++)board[i][j]=board[i-1][j]+board[i][j-1]-board[i-1][j-1]+readInt();
		}
		for(int x = 1; x<=H; x++) {
			for(int y = 1; y<=W; y++) {
				for(int a = x; a<=H; a++) {
					int b = Math.min(W,y+(tolerance/(a-x+1))-1);
					max = Math.max(max,board[a][b]-board[x-1][b]-board[a][y-1]+board[x-1][y-1]);
				}
			}
		}
		System.out.println(max);
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