import java.util.*;
import java.io.*;
public class Traktor {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		int[][] grid = new int[300001][4];
    	for(int i = 0; i < N; i++){
        	int X = readInt(), Y = readInt();
        	grid[X][0]++;
        	grid[Y][1]++;
        	grid[(X+Y)-1][2]++;
        	grid[(X-Y)+100001][3]++;
        	if(grid[X][0] >= K || grid[Y][1] >= K || grid[X + Y - 1][2] >= K || grid[X - Y + 100001][3] >= K){
        		System.out.println(i+1);
            	return;
        	}
    	}
    	System.out.println("-1");
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