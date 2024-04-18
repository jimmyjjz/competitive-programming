import java.util.*;
import java.io.*;
public class Square {
	public static int convert(char in) {
		if(Character.isDigit(in)) {
			return in-48;
		}
			return in-55;
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int[] check = new int[36];
		int N = readInt();
		int[][] board = new int[N][N];
		String s = "";
		boolean reduced = true;
		for(int i = 0; i<N; i++) {
			s = readLine();
			for(int j = 0; j<N; j++) {
				board[i][j] = convert(s.charAt(j));
			}
		}
		for(int i = 1; i<N; i++) {
			if(board[0][i-1] > board[0][i] || board[i-1][0] > board[i][0]) {
				reduced = false;
			}
		}
		for(int i = 0; i<N; i++) {
			Arrays.fill(check, 0);
			for(int j = 0; j<N; j++) {
				check[board[i][j]]++;
			}
			if(Arrays.toString(check).contains("2")) {
				System.out.println("No");
				return;
			}
		}
		for(int i = 0; i<N; i++) {
			Arrays.fill(check, 0);
			for(int j = 0; j<N; j++) {
				check[board[j][i]]++;
			}
			if(Arrays.toString(check).contains("2")) {
				System.out.println("No");
				return;
			}
		}
		if(reduced) {
			System.out.println("Reduced");
		}
		else {
			System.out.println("Latin");
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