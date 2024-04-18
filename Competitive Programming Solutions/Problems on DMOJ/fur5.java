import java.util.*;
import java.io.*;
public class Hanoi {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static void tower(int n, char a, char b, char c){
		if(n == 1){
			System.out.println(a+""+b);
			return;
		}
		tower(n - 1, a, c, b);
		System.out.println(a+"" +b );
		tower(n - 1, c, b, a);
}	

	public static void main(String[] args) throws IOException{
	    tower(readInt(), 'A', 'C', 'B');
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