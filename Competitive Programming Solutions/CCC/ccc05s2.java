import java.util.*;
import java.io.*;
public class mouse {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int C = readInt(); 
		int R = readInt();
		int x = 0;
		int y = 0;
		int v = 0;
		boolean a = false;
		boolean b = false;
	while(true) {
		a = false;
		b = false;
		v = readInt();
		if(v == 0) {
			a = true;
		}
		if(x+v < 0) {
			x = 0;
		}
		else if(x+v > C) {
			x = C;
		}
		else {
			x = x+v;
		}
		v = readInt();
		if(v == 0) {
			b = true;
		}
		if(y+v < 0) {
			y = 0;
		}
		else if(y+v > R) {
			y = R;
		}
		else {
			y = y+v;
		}
		if(a && b) {
			break;
		}
		System.out.println(x+" "+y);
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