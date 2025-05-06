import java.util.*;
import java.io.*;
public class Triangle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int n = readInt();
		for(int i = 0; i<n; i++) {
			long[] all = new long[3];
			long save = readLong();
			all[0] = save*save;
			save = readLong();
			all[1] = save*save;
			save = readLong();
			all[2] = save*save;
			Arrays.sort(all);
			if(all[2]<all[1]+all[0]) {
				System.out.println("A");
			}
			else if(all[2]==all[1]+all[0]) {
				System.out.println("R");
			}
			else {
				System.out.println("O");
			}
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