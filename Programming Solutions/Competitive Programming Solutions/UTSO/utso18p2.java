import java.util.*;
import java.io.*;
public class ABCs{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int[][] board = new int[3][3];
		for(int i = 0; i<3; i++) {
			for(int j = 0; j<3; j++)board[i][j]=readInt();
		}
		int sum = 0;
		if(board[1][0]==board[0][2]&&board[2][0]>0)sum+=board[2][0];
		if(board[1][1]==board[0][0]&&board[2][1]>0)sum+=board[2][1];
		if(board[1][2]==board[0][1]&&board[2][2]>0)sum+=board[2][2];
		System.out.println(sum);
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