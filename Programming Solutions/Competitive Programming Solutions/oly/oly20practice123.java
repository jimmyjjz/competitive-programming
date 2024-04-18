import java.util.*;
import java.io.*;
public class CountOddDigit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String N = readLine();
		int digit = N.length();
		long total = 0;
		String con;
		if(digit%2!=0) {
			con = "1";
			for(int j = 1; j<digit; j++) {
				con+="0";
			}
			total=Long.parseLong(N)-Long.parseLong(con)+1;
			//System.out.println(total);
		}
			for(int i = 1; i<digit; i+=2) {
				con = "9";
				for(int j = 1; j<i; j++) {
					con+="0";
				}
				total+=Long.parseLong(con);
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