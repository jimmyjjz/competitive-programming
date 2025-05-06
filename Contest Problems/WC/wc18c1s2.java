import java.util.*;
import java.io.*;
public class EssayGenerator{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int cap = 1,cnt = 0,N;
	public static void r(int len, String s) {
		if(cnt>=N)return;
		if(len==cap) {
		System.out.print(s+" ");
		cnt++;
		return;
		}
		for(int i = 0; i<26; i++)r(len+1,s+(char)(97+i));
	}
	public static void main(String[] args) throws IOException{
		N = readInt();
		while(N>cnt) {
			r(0,"");
			cap++;
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