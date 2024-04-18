import java.util.*;
import java.io.*;
public class LineTrace{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), sum = 0, bit[] = new int[N+1];
		for(int i = 1; i<=N; i++) {
			for(int j = i; j<=N; j+=j&-j)bit[j]++;
		}
		boolean[] appeared = new boolean[N+1];
		for(int i = 0; i<N; i++) {
			int in = readInt();
			if(appeared[in]) {
				System.out.println("-1");
				return;
			}
			for(int j = in; j<=N; j+=j&-j)bit[j]--;
			for(int j = in; j>0; j-=j&-j)sum+=bit[j];
			appeared[in]=true;
		}
		System.out.println(sum);
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