import java.util.*;
import java.io.*;
public class MadScientist {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt();
	String a = readLine(), b = readLine();
	int cnt = 0;
	boolean type = true;
	for(int i = 0; i<N; i++) {
		if(a.charAt(i) != b.charAt(i)) {
			if(type){
			type = false;
			cnt++;
			}
		}
		else {
			type = true;
		}
	}
	System.out.println(cnt);
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