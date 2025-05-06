import java.util.*;
import java.io.*;
public class shirts {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> e = new ArrayList<Integer>();
	for(int i = 0; i<10; i++) {
		e.clear();
		int shirts = readInt();
		int events = readInt();
		int days = readInt();
		int count = 0;
		int dirty = 0;
		int save = 0;
		for(int j = 0; j<events; j++) {
			e.add(readInt());
		}
		for(int j = 1; j<days; j++) {
			dirty++;
			save = e.size();
			e.removeAll(Collections.singleton(j));
			shirts = shirts + save-e.size();
			if(dirty == shirts) {
				dirty = 0;
				count++;
			}
		}
		System.out.println(count);
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