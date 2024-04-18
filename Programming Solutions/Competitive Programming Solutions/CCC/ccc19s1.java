import java.util.*;
import java.io.*;
public class Flipper{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int[][] grid = {{1,2},{3,4}};
		for(char c : readLine().toCharArray()) {
			if(c=='H') {
				int a = grid[0][0], b = grid[0][1];
				grid[0][0]=grid[1][0];
				grid[0][1]=grid[1][1];
				grid[1][0]=a;
				grid[1][1]=b;
			}
			else {
				int a = grid[1][0], b = grid[0][0];
				grid[1][0]=grid[1][1];
				grid[0][0]=grid[0][1];
				grid[1][1]=a;
				grid[0][1]=b;
			}
		}
		System.out.println(grid[0][0]+" "+grid[0][1]+"\n"+grid[1][0]+" "+grid[1][1]);
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