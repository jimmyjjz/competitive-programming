import java.util.*;
import java.io.*;
public class LeftOut{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static char[][] board;
	static boolean column(int x) {
		if(board[0][0]==board[0][x]) {
			for(int i = 1; i<N; i++)if(board[i][0]!=board[i][x])return false;
			return true;
		}
		for(int i = 1; i<N; i++)if(board[i][0]==board[i][x])return false;
		return true;
	}
	static boolean row(int x) {
		if(board[0][0]==board[x][0]) {
			for(int i = 1; i<N; i++)if(board[0][i]!=board[x][i])return false;
			return true;
		}
		for(int i = 1; i<N; i++)if(board[0][i]==board[x][i])return false;
		return true;
	}
	public static void main(String[] args) throws IOException{
		N = readInt();
		board = new char[N][N];
		for(int i = 0; i<N; i++) {
			String s = readLine();
			for(int j = 0; j<N; j++)board[i][j]=s.charAt(j);
		}
		int wC = 0, wR = 0, C = -1, R = -1;
		boolean flag = false;
		for(int i = 1; i<N; i++) {
			if(!column(i)) {
				wC++;
				if(!flag) {
					C=i;
					flag=true;
				}
			}
		}
		flag = false;
		for(int i = 1; i<N; i++) {
			if(!row(i)) {
				wR++;
				if(!flag) {
					R=i;
					flag=true;
				}
			}
		}
		if(wC==N-1&&wR==N-1)System.out.println("1 1");
		else if(wR==N-1)System.out.println("1 "+(C+1));
		else if(wC==N-1)System.out.println((R+1)+" 1");
		else if(wC!=1&&wR!=1)System.out.println("-1");
		else System.out.println((R+1)+" "+(C+1));
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