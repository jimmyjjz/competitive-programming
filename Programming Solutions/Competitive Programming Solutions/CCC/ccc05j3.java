import java.util.*;
import java.io.*;
public class returns {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Stack<String> all = new Stack<String>();
		String input = "";
		String direction = "";
		String place = "";
		while(true) {
			input = readLine();
			all.add(input);
			if(input.equals("SCHOOL")) {
				break;
			}
		}
		all.pop();
		while(!all.isEmpty()) {
			if(all.pop().equals("L")) {
				direction = "RIGHT";
			}
			else {
				direction = "LEFT";
			}
			if(all.isEmpty()) {
				break;
			}
			place = all.pop();
		System.out.println("Turn "+direction+" onto "+place+" street.");
		}
		System.out.println("Turn "+direction+" into your HOME.");
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