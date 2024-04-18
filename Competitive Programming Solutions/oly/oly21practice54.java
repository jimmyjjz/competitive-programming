import java.util.*;
import java.io.*;
public class BobHated {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int X = readInt(), N = readInt();
		boolean[] arr = new boolean[1000001];
		for(int i = 0; i<N; i++) {
			arr[readInt()] = true;
		}
		int incre = 1;
		if(!arr[X]) {
			System.out.println(X);
			return;
		}
		while(true) {
			if(!arr[X-incre]) {
				System.out.println(X-incre);
				break;
			}
			if(!arr[X+incre]) {
				System.out.println(X+incre);
				break;
			}
			incre++;
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