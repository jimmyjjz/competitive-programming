import java.util.*;
import java.io.*;
public class BrotherlySequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), biggest = 1;
		int[] scores = new int[N+1];
		Arrays.fill(scores,1);
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
		}
		for(int i = 1; i<N; i++) {
			if(Math.abs(arr[i]-arr[i-1]) <= 2) {
				scores[i] = scores[i-1] + 1;
				if(biggest<scores[i]) {
					biggest = scores[i];
				}
				continue;
			}
			scores[i] = 1;
		}
		System.out.println(biggest);
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