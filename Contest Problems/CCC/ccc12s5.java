import java.util.*;
import java.io.*;
public class MouseJourney {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		 int R = readInt(), C = readInt(),K = readInt();
		    int[][] board = new int[R][C];
		    boolean[][] cat = new boolean[R][C];
		    for(int i = 0; i<K; i++)cat[readInt()-1][readInt()-1]=true;
		    board[0][0]=1;
		    for(int i = 1; i<R; i++){
		      if(!cat[i][0])board[i][0]=1;
		      else break;
		    }
		    for(int j = 1; j<C; j++){
		      if(!cat[0][j])board[0][j]=1;
		      else break;
		    }  
		    for(int i = 1; i<R; i++){
		      for(int j = 1; j<C; j++){
		        if(!cat[i][j])board[i][j]=board[i-1][j]+board[i][j-1];
		      } 
		    }
		    System.out.println(board[R-1][C-1]);
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