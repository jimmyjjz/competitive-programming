import java.util.*;
import java.io.*;
public class Ragaman{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String s = readLine();
		int len = s.length(), letters[][] = new int[26][2];
		for(int i = 0; i<len; i++)if(s.charAt(i)!='*')letters[s.charAt(i)-'a'][0]++;
		s = readLine();
		len = s.length();
		for(int i = 0; i<len; i++)if(s.charAt(i)!='*')letters[s.charAt(i)-'a'][1]++;
		for(int i = 0; i<26; i++) {
			if(letters[i][0]<letters[i][1]) {
				System.out.println("N");
				return;
			}
		}
		System.out.println("A");
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