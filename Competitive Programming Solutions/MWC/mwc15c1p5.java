import java.util.*;
import java.io.*;
public class guru {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static int save = 0;
	public static int calculate(String in) {
		int temp = 0;
		for(int i = 1; i<=in.length(); i++) {
			switch(i%4) {
			case 0: temp+=(Math.pow(alphabet.indexOf(in.charAt(i-1))+1, 4))%10; break;
			case 1: temp+=(Math.pow(alphabet.indexOf(in.charAt(i-1))+1, 1))%10; break;
			case 2: temp+=(Math.pow(alphabet.indexOf(in.charAt(i-1))+1, 2))%10; break;
			case 3: temp+=(Math.pow(alphabet.indexOf(in.charAt(i-1))+1, 3))%10; break;
			}
		}
		if(temp%10==0) {
			return 10;
		}
		else {
			return temp%10;
		}
	}
	public static void main(String[] args) throws IOException{
		System.out.println(calculate(readLine().toUpperCase())+calculate(readLine().toUpperCase()));
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