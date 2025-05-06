import java.util.*;
import java.io.*;
public class TreeShopping{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean inTriangle(long x, long y, long tx1, long ty1, long tx2, long ty2, long tx3, long ty3) {
		double a = (x-tx2)*(ty1-ty2)-(tx1-tx2)*(y-ty2), 
		b = (x-tx3)*(ty2-ty3)-(tx2-tx3)*(y-ty3), 
		c = (x-tx1)*(ty3-ty1)-(tx3-tx1)*(y-ty1);
		return !((a>0||b>0||c>0)&&(a<0||b<0||c<0));
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		long triangle[][] = new long[N][6];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<6; j++)triangle[i][j]=readLong();
		}
		for(int i = 0; i<Q; i++) {
			int x = readInt(), y = readInt(), cnt = 0;
			for(int j = 0; j<N; j++)if(inTriangle(x,y,triangle[j][0],triangle[j][1],triangle[j][2],triangle[j][3],triangle[j][4],triangle[j][5]))cnt++;
			System.out.println(cnt);
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