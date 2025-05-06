import java.util.*;
import java.io.*;
public class golf {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int dis = readInt(), n = readInt();
		int[] clubs = new int[n];
		for(int i = 0; i<n; i++)clubs[i]=readInt();
		Arrays.sort(clubs);
		int[] board = new int[dis+1];
		boolean[] seen = new boolean[dis+1];
		Arrays.fill(board, 5281);
		seen[0]=true;
		board[0]=0;
		for(int i = 1; i<=dis; i++) {
			for(int j = 0; j<n&&i>=clubs[j]; j++) {
				if(seen[i-clubs[j]]) {
					board[i]=Math.min(board[i], board[i-clubs[j]]+1);
					seen[i]=true;
				}
			}
		}
		//System.out.println(Arrays.toString(board));
		//System.out.println(Arrays.toString(seen));
		System.out.println((!seen[dis])?"Roberta acknowledges defeat.":"Roberta wins in "+board[dis]+" strokes.");
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