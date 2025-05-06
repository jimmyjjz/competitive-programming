import java.util.*;
import java.io.*;
public class bobhistogram {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) {
			nums[i] = readInt();
		}
		int min = Integer.MAX_VALUE;
		for(int i = -100; i<=100; i++) {
			int total = 0;
			for(int j = 0; j<N; j++) {
				total+=(nums[j]-i)*(nums[j]-i);
			}
			min=Math.min(min, total);
		}
		System.out.println(min);
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