import java.util.*;
import java.io.*;
public class WordCount {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<5; i++) {
			int cnt = 0, total = 0;
			String s = readLine();
			for(int j = 0; j<s.length(); j++) {
				if(Character.isAlphabetic(s.charAt(j))){
					cnt++;
				}
				if(Character.isWhitespace(s.charAt(j)) || (s.charAt(j)+"").equals("'") || j == s.length()-1){
					if(cnt > 3) {
						total++;
					}
					cnt = 0;
				}
			}
			System.out.println(total);
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