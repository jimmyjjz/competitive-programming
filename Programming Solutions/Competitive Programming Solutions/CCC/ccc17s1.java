import java.util.*;
import java.io.*;
public class SumGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), result = 0;
		int [] Swifts = new int[N+1], Semaphores = new int[N+1];
		for(int i = 1; i<=N; i++) {
			Swifts[i] = Swifts[i-1]+readInt();
		}
		for(int i = 1; i<=N; i++) {
			Semaphores[i] = Semaphores[i-1]+readInt();
		}
		for(int i = 0; i<=N; i++) {
			if(Swifts[i]==Semaphores[i]) {
				result = i;
			}
		}
		if(result==0) {
			System.out.println("0");
		}
		else {
		System.out.println(result);
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