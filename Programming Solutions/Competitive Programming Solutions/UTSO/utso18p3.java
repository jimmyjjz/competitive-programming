import java.util.*;
import java.io.*;
public class Restaurants {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), T = readInt(), K = readInt(), V = readInt();
		boolean[] street = new boolean[N+1];
		for(int i = 0; i<V; i++) {
			street[readInt()] = true;
		}
		int bot = 1, top = T, count = 0, total = 0;
		for(int i = bot; i<=top; i++) {
			if(street[i]) {
				total++;
			}
		}
		if(total<K) {
			for(int i = top; i>=bot; i--) {
				if(!street[i]) {
					street[i] = true;
					total++;
					count++;
				}
				if(total>=K) {
					break;
				}
			}
		}
		while(true) {
			if(total<K) {
				for(int i = top; i>=bot;) {
					if(!street[i]) {
					count++;
					total++;
					street[i] = true;
					break;
					}
					i--;
				}
			}
			bot++;
			top++;
			if(top > N) {
				break;
			}
			if(street[bot-1]) {
				total--;
			}
			if(street[top]) {
				total++;
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