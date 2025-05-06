import java.util.*;
import java.io.*;
public class TheMostImportantSkillinBiology {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int a = 0, b = 0;
		int n = readInt();
		int[][] pos = new int[n][2];
		for(int i = 0; i<n; i++) {
			pos[i][0]=readInt();
			pos[i][1]=readInt();
		}
		for(int i = 0; i<n-1; i++) {
			a+=pos[i][0]*pos[i+1][1];
			b+=pos[i][1]*pos[i+1][0];
		}
		a+=pos[n-1][0]*pos[0][1];
		b+=pos[n-1][1]*pos[0][0];
		System.out.println((int)Math.ceil(Math.abs(a-b)/2.0));
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