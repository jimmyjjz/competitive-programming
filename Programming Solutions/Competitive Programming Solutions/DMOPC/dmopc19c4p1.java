import java.util.*;
import java.io.*;
public class ValidStrings{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		for(int i = 0; i<N; i++) {
			int o = 0, c = 0;
			char[] arr = readLine().toCharArray();
			out:{
			for(char ch : arr) {
				if(ch=='(')o++;
				else if(ch==')')c++;
				if(c>o) {
					System.out.println("NO");
					break out;
				}
			}
			System.out.println(o==c?"YES":"NO");
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