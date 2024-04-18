import java.util.*;
import java.io.*;
public class BlackandWhite{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		byte board[][] = new byte[N+1][N+1];
		for(int i = 0; i<M; i++) {
			int r1 = readInt()+1, c1 = readInt()+1, r2 = readInt()+r1-1, c2 = readInt()+c1-1;
			try{board[r1][c1]++;}catch(Exception e) {}
			try{board[r2+1][c2+1]++;}catch(Exception e) {}
			try{board[r2+1][c1]--;}catch(Exception e) {}
			try{board[r1][c2+1]--;}catch(Exception e) {}
		}
		int cnt = 0;
		for(int i = 1; i<=N; i++) {
			for(int j = 1; j<=N; j++) {
				board[i][j]=(byte)((board[i][j]+board[i-1][j]+board[i][j-1]-board[i-1][j-1])%2);
				if(board[i][j]%2!=0)cnt++;
			}
		}
		System.out.println(cnt);
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