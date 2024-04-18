import java.util.*;
import java.io.*;
public class msg {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int time = readInt();
		int interval = readInt();
		int send = readInt();
		for(int i = 0; i<3; i++) {
			time += interval;
			if(send <= time) {
				System.out.println(time);
				return;
			}
			if(time > 100) {
				break;
			}
		}
		System.out.println("Who knows...");
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