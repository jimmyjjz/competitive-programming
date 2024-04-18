import java.util.*;
import java.io.*;
public class queens {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int size = readInt();
	int q = readInt();
	LinkedList<String> loc = new LinkedList<String>();
	for(int i = 0; i<q; i++) {
		int x = readInt();
		int y = readInt();
		for(int j = 1; j<=size; j++) {
			loc.add(x+" "+j);
		}
		for(int j = 1; j<=size; j++) {
			loc.add(j+" "+y);
		}
		for(int j = 1; j<=size; j++) {
			if(x+j > size || y+j > size) {
				break;
			}
			loc.add((x+j)+" "+(y+j));
		}
		for(int j = 1; j<=size; j++) {
			if(x-j < 1 || y-j < 1) {
				break;
			}
			loc.add((x-j)+" "+(y-j));
		}
		for(int j = 1; j<=size; j++) {
			if(x-j < 1 || y+j > size) {
				break;
			}
			loc.add((x-j)+" "+(y+j));
		}
		for(int j = 1; j<=size; j++) {
			if(x+j > size || y-j < 1) {
				break;
			}
			loc.add((x+j)+" "+(y-j));
		}
	}
	Set<String> set = new HashSet<String>(loc);
	System.out.println((size*size) - set.size());
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