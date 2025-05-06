import java.util.*;
import java.io.*;
public class OCanada{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int S = readInt(), N = readInt(), finalstate[] = new int[1<<(S*2)];
		boolean[][] grid = new boolean[S][S];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<S; j++) {
				String s = readLine();
				for(int k = 0; k<S; k++)grid[j][k]=s.charAt(k)=='R'?true:false;
			}
			for(int j = 0; j<S-1; j++) {
				for(int k = 0; k<S-1; k++) {
					if(grid[j][k])continue;
					grid[j][k]=!grid[j][k];
					grid[j+1][k]=!grid[j+1][k];
					grid[j][k+1]=!grid[j][k+1];
					grid[j+1][k+1]=!grid[j+1][k+1];
				}
			}
			int in = 0, k = 0;
			for(int j = 0; j<S; j++) {
				if(grid[S-1][j])in|=1<<k;
				k++;
			}
			for(int j = S-2; j>=0; j--) {
				if(grid[j][S-1])in|=1<<k;
				k++;
			}
			finalstate[in]++;
		}
		int result = 0;
		for(int i : finalstate)result+=(i*(i-1))/2;
		System.out.println(result);
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