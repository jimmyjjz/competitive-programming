import java.util.*;
import java.io.*;
public class PermutationsAndProducts {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long[] board = new long[N-1];
		for(int i = 2; i<=N; i++) {
			System.out.println("? 1 "+i);
			System.out.flush();
			board[i-2]=readLong();
			if(board[i-2]==-1)return;
		}
		long[] clone = board.clone();
		Arrays.sort(clone);
		if(N==3) {
			if(board[0]==2&&board[1]==6) {
				System.out.println("! 2 1 3");
				return;
			}
			if(board[0]==6&&board[1]==2) {
				System.out.println("! 2 3 1");
				return;
			}
		}
		long min = clone[1]-clone[0];
		for(int i = 1; i<N-2; i++)min=Math.min(min,clone[i+1]-clone[i]);
		System.out.print("! "+min);
		for(int i = 0; i<N-1; i++)System.out.print(" "+(board[i]/min));
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