import java.util.*;
import java.io.*;
public class Neko {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int R = readInt(), C = readInt();
		boolean[][] pos = new boolean[1001][1001];
		for(int i = 0; i<R; i++) {
			String s = readLine();
			for(int j = 0; j<C; j++) {
				if(s.charAt(j) == 'X') {
					pos[j+1][i+1] = true;
				}
				
			}
		}
		int Q = readInt();
		for(int i = 0; i<Q; i++) {
			int h = readInt(), v = readInt();
			boolean found = false;
			if(pos[h][v]) {
				found = true;
			}
			if(found) {
				System.out.println("Y");
				continue;
			}
			for(int j = 1; j<=R; j++) {
				if(pos[h][j]) {
					found = true;
					break;
				}
			}
			if(found) {
				System.out.println("Y");
				continue;
			}
			for(int j = 1; j<=C; j++) {
				if(pos[j][v]) {
					found = true;
					break;
				}
			}
			if(found) {
				System.out.println("Y");
				continue;
			}
				System.out.println("N");
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