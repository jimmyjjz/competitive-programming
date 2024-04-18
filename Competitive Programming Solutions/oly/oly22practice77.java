import java.util.*;
import java.io.*;
public class Posters{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int X = readInt(), Y = readInt(), N = readInt(), wall[][] = new int[X+1][Y+1], cnt = 0;
		for(int i = 0; i<N; i++) {
			int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
			try {wall[x1][y1]++;}catch(Exception e) {};
			try {wall[x1][y2+1]--;}catch(Exception e) {};
			try {wall[x2+1][y1]--;}catch(Exception e) {};
			try {wall[x2+1][y2+1]++;}catch(Exception e) {};
		}
		for(int i = 1; i<=X; i++) {
			for(int j = 1; j<=Y; j++) {
				wall[i][j]+=wall[i-1][j]+wall[i][j-1]-wall[i-1][j-1];
				if(wall[i][j]>0)cnt++;
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