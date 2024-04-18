import java.util.*;
import java.io.*;
public class BobsTripPlan {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] dif = new int[N];
		int now = 0, total = 0;
		for(int i = 0; i<N; i++) {
			int in = readInt();
			dif[i]=in;
			total+=Math.abs(now-in);
			now = in;
		}
		total+=Math.abs(now);
		System.out.println(total-Math.abs(dif[0])-Math.abs(dif[0]-dif[1])+Math.abs(dif[1]));
		for(int i = 1; i<N-1; i++) {
			System.out.println(total-Math.abs(dif[i-1]-dif[i])-Math.abs(dif[i]-dif[i+1])+Math.abs(dif[i-1]-dif[i+1]));
		}
		System.out.println(total-Math.abs(dif[N-1])-Math.abs(dif[N-2]-dif[N-1])+Math.abs(dif[N-2]));
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