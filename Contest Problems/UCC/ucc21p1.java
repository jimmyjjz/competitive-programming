import java.util.*;
import java.io.*;
public class Counterfeit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String s = readLine();
		int count = 0;
		for(int i = 0; i<s.length(); i++) {
			if((s.charAt(i)+"").equals("2")) {
				try {
				if(!(s.charAt(i+1)+"").equals("5")) {
				count++;
				}
				}
				catch(Exception e) {
					count++;
				}
			}
		}
		System.out.println(count);
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