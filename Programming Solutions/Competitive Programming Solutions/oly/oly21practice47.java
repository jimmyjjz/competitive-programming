import java.util.*;
import java.io.*;
public class WordConver {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String in = readLine();
		String tar = readLine();
		if(in.equals(tar)) {
			System.out.println("Yes");
			return;
		}
		if(in.length() != tar.length()+1) {
			System.out.println("No");
			return;
		}
		int incre = 0;
		try {
		for(int i = 0; i<in.length(); i++) {
			if(in.charAt(i) != tar.charAt(i-incre)) {
				incre++;
			}
		}
		}
		catch(StringIndexOutOfBoundsException e) {
		}
		if(incre <= 1||in.substring(0,in.length()-1).equals(tar)) {
			System.out.println("Yes");
			return;
		}
		System.out.println("No");
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