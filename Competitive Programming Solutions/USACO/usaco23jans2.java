import java.util.*;
import java.io.*;
public class FollowingDirections{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), board[][] = new int[N+1][N+1], traffic[][] = new int[N+1][N+1];
		for(int i = 0; i<N; i++) {
			String s = next();
			for(int j = 0; j<N; j++)board[i][j]=s.charAt(j)=='R'?-1:-2;
			board[i][N]=readInt();
		}
		for(int i = 0; i<N; i++)board[N][i]=readInt();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				traffic[i][j]++;
				if(board[i][j]==-2)traffic[i+1][j]+=traffic[i][j];
				else traffic[i][j+1]+=traffic[i][j];
			}
		}
		int sum = 0;
		for(int i = 0; i<=N; i++)sum+=traffic[i][N]*board[i][N];
		for(int i = 0; i<=N; i++)sum+=traffic[N][i]*board[N][i];
		System.out.println(sum);
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int r = readInt()-1, c = readInt()-1, remove = traffic[r][c], R = r, C = c;
			while(board[R][C]<0) {
				if(board[R][C]==-1)C++;
				else R++;
				traffic[R][C]-=remove;
			}
			if(board[r][c]==-1)board[r][c]=-2;
			else board[r][c]=-1;
			while(board[r][c]<0) {
				if(board[r][c]==-1)c++;
				else r++;
				traffic[r][c]+=remove;
			}
			sum = 0;
			for(int j = 0; j<=N; j++)sum+=traffic[j][N]*board[j][N];
			for(int j = 0; j<=N; j++)sum+=traffic[N][j]*board[N][j];
			System.out.println(sum);
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