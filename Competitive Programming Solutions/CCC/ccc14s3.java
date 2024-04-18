import java.util.*;
import java.io.*;
public class Confection {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int i = 0; i<T; i++) {
			Stack<Integer> top = new Stack<Integer>();
			Stack<Integer> branch = new Stack<Integer>();
			int N = readInt();
			boolean end = false;
			for(int j = 0; j<N; j++) {
				top.push(readInt());
			}
			for(int j = 1; j<=N; j++) {
			if(!branch.isEmpty() && branch.peek() == j) {
				branch.pop();
				continue;
			}
			while(!top.isEmpty() && top.peek() != j) {
				if(top.peek() == j) {
					top.pop();
					break;
				}
				branch.push(top.pop());
			}
			if(!top.isEmpty() && top.peek() == j) {
				top.pop();
				continue;
			}
			if(top.isEmpty() && branch.peek() != j) {
				end = true;
				break;
			}
			}
			if(!end) {
				System.out.println("Y");
			}
			else {
				System.out.println("N");
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