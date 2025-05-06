import java.util.*;
import java.io.*;
public class LazerGrid {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int X = readInt(), Y = readInt(), N = readInt(), M = readInt(), C = readInt();
		int top = 1000000, right = 1000000, bottom = 0, left = 0; 
		for(int i = 0; i<N; i++) {
			int n = readInt();
			if(n>X)right=Math.min(right, n);
			else left=Math.max(left, n);
		}
		for(int i = 0; i<M; i++) {
			int n = readInt();
			if(n>Y)top=Math.min(top, n);
			else bottom=Math.max(bottom, n);
		}
		for(int i = 0; i<C; i++) {
			int x = readInt(), y = readInt();
			if(x>left&&x<right&&y<top&&y>bottom)System.out.println("Y");
			else System.out.println("N");
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