import java.util.*;
import java.io.*;
public class dwarves {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int sum = 0, a = 0, b = 0;
	int[] dwarves = new int[9];
	for(int i = 0; i<9; i++) {
		dwarves[i] = readInt();
	}
	for(int i = 0; i<9; i++) {
		a = i;
		for(int j = 0; j<9; j++) {
			if(j == i) {
				continue;
			}
			b = j;
			sum = 0;
			for(int k = 0; k<9; k++) {
				if(k == i || k == j) {
					continue;
				}
				sum += dwarves[k];
		}
			if(sum == 100) {
				for(int z = 0; z<9; z++) {
					if(z == a || z == b) {
						continue;
					}
					System.out.println(dwarves[z]);
			}
				return;
		}
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