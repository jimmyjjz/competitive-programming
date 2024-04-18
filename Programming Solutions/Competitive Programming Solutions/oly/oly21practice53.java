import java.util.*;
import java.io.*;
public class ChickenAndRabbit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int h = readInt();
		int l = readInt();
		if(l%2.0!=0 || l>(h*4)) {
			System.out.println("No");
			return;
		}
		for(int i = 0; i<h; i++) {
			l-=2;
		}
		if(l>=0) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
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