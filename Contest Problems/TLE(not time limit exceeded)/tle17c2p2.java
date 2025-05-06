import java.util.*;
import java.io.*;
public class UnluckyNumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int[] Board = new int[1000001];
		int N = readInt();
		for(int i = 0; i<N; i++){
			Board[readInt()]=1;
		}
		int[] Process = new int[1000001];
		for(int i = 1; i<1000001; i++) {
			Process[i] = Process[i-1]+Board[i];
		}
		Process[0] = 0;
		int K = readInt();
		for(int i = 0; i<K; i++) {
			int save = readInt();
			System.out.println(save-Process[save]);
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