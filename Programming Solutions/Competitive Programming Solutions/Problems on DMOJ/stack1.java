import java.util.*;
import java.io.*;
public class TheDMOJDriveway{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt(), M = readInt();
		Deque<String> line = new LinkedList<String>();
		for(int i = 0; i<T; i++) {
			String[] s = readLine().split(" ");
			if(s[1].equals("in"))line.add(s[0]);
			else if(line.peekLast().equals(s[0]))line.pollLast();
			else if(line.peekFirst().equals(s[0])&&M-->0)line.pollFirst();
		}
		for(String s : line)System.out.println(s);
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