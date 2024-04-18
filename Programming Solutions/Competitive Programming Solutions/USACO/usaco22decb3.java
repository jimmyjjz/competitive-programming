import java.util.*;
import java.io.*;
public class ReverseEngineering{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++) {
			int N = readInt(), M = readInt(), grid[][] = new int[M][N], results[] = new int[M];
			for(int j = 0; j<M; j++) {
				String s = next();
				results[j]=readInt();
				for(int k = 0; k<N; k++)grid[j][k]=Integer.parseInt(s.charAt(k)+"");
			}
			boolean[] statementExists = new boolean[N], cut = new boolean[M];
			for(int j = 0; j<N; j++) {
				if(statementExists[j])continue;
				int one = -1, zero = -1;
				for(int k = 0; k<M; k++) {
					if(cut[k])continue;
					if(grid[k][j]==0) {
						if(zero==-1)zero=results[k];
						else if(zero!=results[k])zero=-2;
					}
					else {
						if(one==-1)one=results[k];
						else if(one!=results[k])one=-2;
					}
				}
				if(one>=0) {
					statementExists[j]=true;
					for(int k = 0; k<M; k++)if(grid[k][j]==1)cut[k]=true;
					j=0;
				}
				if(zero>=0) {
					statementExists[j]=true;
					for(int k = 0; k<M; k++)if(grid[k][j]==0)cut[k]=true;
					j=0;
				}
			}
			out:{
			for(int j = 0, r = -1; j<M; j++) {
				if(cut[j])continue;
				if(r==-1)r=results[j];
				if(r!=results[j]) {
					System.out.println("LIE");
					break out;
				}
			}
			System.out.println("OK");
			}
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