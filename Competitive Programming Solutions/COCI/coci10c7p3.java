import java.util.*;
import java.io.*;
public class Gitara{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), P = readInt(), moves = 0;
		Stack<Integer>[] strings = new Stack[7];
		for(int i = 1; i<=6; i++)strings[i]=new Stack<Integer>();
		for(int i = 0; i<N; i++) {
			int s = readInt(), f = readInt();
			while(!strings[s].isEmpty()&&f<strings[s].peek()) {
				strings[s].pop();
				moves++;
			}
			if(strings[s].isEmpty()||f!=strings[s].peek()) {
				strings[s].push(f);
				moves++;
			}
		}
		System.out.println(moves);
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