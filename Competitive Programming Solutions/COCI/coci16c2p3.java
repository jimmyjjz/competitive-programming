import java.util.*;
import java.io.*;
public class Nizin{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), moves = 0;
		long f = 0,b = 0,nums[] = new long[N];
		for(int i = 0; i<N; i++)nums[i]=readLong();
		int dexf = -1, dexb = N;
		while(dexb>dexf) {
			if(f==b) {
				f+=nums[++dexf];
				b+=nums[--dexb];
			}
			else if(f<b) {
				moves++;
				f+=nums[++dexf];
			}
			else {
				moves++;
				b+=nums[--dexb];
			}
		}
		System.out.println(moves);
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