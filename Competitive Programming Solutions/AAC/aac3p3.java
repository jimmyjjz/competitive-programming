import java.util.*;
import java.io.*;
public class MonkeyMart {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] board = new int[N];
		for(int i = 0; i<N; i++) {
			board[i] = readInt();
		}
		Arrays.sort(board);
		if(N%2!=0) {
			System.out.print(board[N/2]+" ");
		}
		for(int i = N/2; i>1; i--) {
			System.out.print(board[i-1]+" "+board[N-i]+" ");
		}
		System.out.print(board[0]+" "+board[N-1]);
		System.out.println();
		if(N%2!=0) {
			System.out.print("E");
		}
		for(int i = N/2; i>=1; i--) {
			System.out.print("BS");
		}
		System.out.println();
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