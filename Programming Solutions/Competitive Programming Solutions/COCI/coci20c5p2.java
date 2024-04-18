import java.util.*;
import java.io.*;
public class Po{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), cnt = 0;
		Stack<Integer> monotonic = new Stack<Integer>();
		monotonic.push(0);
		for(int i = 0; i<N; i++) {
			int in = readInt();
			while(!monotonic.isEmpty()&&monotonic.peek()>in)monotonic.pop();
			if(!monotonic.isEmpty()&&in==monotonic.peek())continue;
			cnt++;
			monotonic.push(in);
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