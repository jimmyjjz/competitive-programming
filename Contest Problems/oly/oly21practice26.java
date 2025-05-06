import java.util.*;
import java.io.*;
public class rect {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		LinkedList<String> all = new LinkedList<String>();
		int savex = 0;
		int savey = 0;
		String colour = "";
		int N = readInt();
		for(int i = 1; i<N+1; i++) {
		all.add(readLine()+" "+i);
		}
		StringTokenizer split = new StringTokenizer(readLine(), " ");
		int x = Integer.parseInt(split.nextToken());
		int y = Integer.parseInt(split.nextToken());
		for(int j = 0; j<N; j++) {
		StringTokenizer cut = new StringTokenizer(all.remove(0), " ");
		savex = Integer.parseInt(cut.nextToken());
		savey = Integer.parseInt(cut.nextToken());
		if(x >= savex && x <= savex+Integer.parseInt(cut.nextToken()) && y >= savey && y <= savey+Integer.parseInt(cut.nextToken())){
			colour = cut.nextToken();
		}
		}
		System.out.println(colour);
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