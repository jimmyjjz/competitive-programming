import java.util.*;
import java.io.*;
public class Cheese {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int len = readInt(), a = readInt(), b = readInt(), num = readInt();
		long total = 0;
		for(int i = 0; i<num; i++) {
			int Asave = readInt(), Bsave = readInt();
			if(Asave > b || Bsave < a) {
				continue;
			}
			if(Asave < a) {
				Asave = a;
			}
			if(Bsave > b) {
				Bsave = b;
			}
			total+=Bsave-Asave+1;
		}
		System.out.println(total);
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