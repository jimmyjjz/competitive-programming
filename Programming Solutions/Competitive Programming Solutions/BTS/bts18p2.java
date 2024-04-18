import java.util.*;
import java.io.*;
public class LetterFre {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	String alphabet = "abcdefghijklmnopqrstuvwxyz";
	String s = readLine();
	int[][] store = new int[s.length()][26];
	for(int i = 0; i<s.length(); i++) {
		if(Character.isWhitespace(s.charAt(i))) {
			continue;
		}
		store[i][alphabet.indexOf(s.charAt(i))]++;
	}
	for(int i = 0; i<26; i++) {
		for(int j = 1; j<s.length(); j++) {
			store[j][i] += store[j-1][i];
		}
	}
	int Q = readInt();
	for(int i = 0; i<Q; i++) {
		int a = readInt(), b = readInt();
		String in = next();
		if(a-2<0) {
			System.out.println(store[b-1][alphabet.indexOf(in)]);
			continue;
		}
		System.out.println(store[b-1][alphabet.indexOf(in)]-store[a-2][alphabet.indexOf(in)]);
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