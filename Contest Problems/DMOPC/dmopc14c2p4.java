import java.util.*;
import java.io.*;
public class Deforestation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] trees = new int[N+1];
		trees[0]=0;
		for(int i = 1; i<=N; i++) {
			trees[i]=readInt()+trees[i-1];
		}
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			System.out.println(Math.abs(trees[readInt()]-trees[readInt()+1]));
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