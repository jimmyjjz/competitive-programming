import java.util.*;
import java.io.*;
public class present {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Stack<Integer> all = new Stack<Integer>();
		int total = 0;
		int count = 0;
		int save = 0;
		int N = readInt();
		for(int i = 0; i<N; i++) {
			all.push(readInt());
		}
		Collections.sort(all);
		Collections.reverse(all);
		while(!all.isEmpty()) {
			save = all.pop();
			if(save >= total) {
			total = total + save;
			count++;
			}
		}
		System.out.println(count);
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