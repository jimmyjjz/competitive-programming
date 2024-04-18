import java.util.*;
import java.io.*;
public class CCCBadHaha{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++) {
			String s = readLine();
			int m = readInt();
			Stack<Character> stk = new Stack<Character>(), residue = new Stack<Character>();
			for(char c : s.toCharArray()) {
				while(!stk.isEmpty()&&c<stk.peek()&&m-->0)residue.push(stk.pop());
				stk.push(c);
			}
			while(!stk.isEmpty()&&m-->0)residue.push(stk.pop());
			for(char c : stk)System.out.print(c);
			Collections.sort(residue);
			for(char c : residue)System.out.print(c);
			System.out.println();
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