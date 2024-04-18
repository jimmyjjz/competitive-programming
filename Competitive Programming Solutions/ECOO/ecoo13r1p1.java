import java.util.*;
import java.io.*;
public class serve {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int start = readInt();
		String in = "";
		while(true) {
			int s = 0,t = 0;
			while(true) {
			in = readLine();
			if(in.equals("CLOSE")) {
				System.out.println(s+" "+t+" "+start);
				break;
			}
			if(in.equals("EOF")) {
				break;
			}
			if(start > 999) {
				start = 1;
			}
			if(in.equals("TAKE")) {
				s++;
				t++;
				start++;
			}
			else{
				t--;
			}
			}
			if(in.equals("EOF")) {
				break;
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