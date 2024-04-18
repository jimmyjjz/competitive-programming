import java.util.*;
import java.io.*;
public class light {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int pre = 0;
		int sec = 0;
		int lights = readInt();
		int road = readInt();
		for(int i = 0; i < lights; i++) {
			int place = readInt();
			int red = readInt();
			int green = readInt();
			sec = sec + (place-pre);
			while(!(sec % (green+red) >= red)) {
				sec++;
			}
			pre = place;
		}
		sec = sec + (road-pre);
		System.out.println(sec);
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