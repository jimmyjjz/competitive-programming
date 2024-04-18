import java.util.*;
import java.io.*;
public class CheckerboardSummationE{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int M = readInt(), N = readInt(), boardA[][] = new int[M+1][N+1], boardB[][] = new int[M+1][N+1];
		int r = readInt(), c = readInt(), x = readInt();
		while(r!=0||c!=0||x!=0) {
			if(r%2==c%2)boardA[r][c]=x;
			else boardB[r][c]=x;
			r = readInt(); c = readInt(); x = readInt();
		}
		for(int i = 1; i<=M; i++) {
			for(int j = 1; j<=N; j++) {
				boardA[i][j]+=boardA[i-1][j]+boardA[i][j-1]-boardA[i-1][j-1];
				boardB[i][j]+=boardB[i-1][j]+boardB[i][j-1]-boardB[i-1][j-1];
			}
		}
		int r1 = readInt(), c1 = readInt(), r2 = readInt(), c2 = readInt();
		while(r1!=0||c1!=0||r2!=0||c2!=0) {
			if(r1%2==c1%2)System.out.println((boardA[r1-1][c1-1]+boardA[r2][c2]-boardA[r1-1][c2]-boardA[r2][c1-1])-(boardB[r1-1][c1-1]+boardB[r2][c2]-boardB[r1-1][c2]-boardB[r2][c1-1]));
			else System.out.println((boardB[r1-1][c1-1]+boardB[r2][c2]-boardB[r1-1][c2]-boardB[r2][c1-1])-(boardA[r1-1][c1-1]+boardA[r2][c2]-boardA[r1-1][c2]-boardA[r2][c1-1]));
			r1 = readInt(); c1 = readInt(); r2 = readInt(); c2 = readInt();
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