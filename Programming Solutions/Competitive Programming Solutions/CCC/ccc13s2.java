import java.util.*;
import java.io.*;
public class BridgeTransport{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int weight = readInt(), N = readInt(), cur = 0, arr[] = new int[N];
		for(int i = 0; i<N; i++)arr[i]=readInt();
		for(int i = 0; i<N; i++) {
			if(i>3)cur-=arr[i-4];
			cur+=arr[i];
			if(cur>weight) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(N);
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