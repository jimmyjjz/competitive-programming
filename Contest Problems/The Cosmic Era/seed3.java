import java.util.*;
import java.io.*;
public class BattlePos {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int I = readInt(), N = readInt(), J = readInt();
		int[] stations = new int[I+1];
		for(int i = 0; i<J; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			stations[a-1]+=c;
			stations[b]-=c;
		}
		for(int i = 1; i<I; i++) {
			stations[i]+=stations[i-1];
		}
		int cnt = 0;
		for(int i = 0; i<I; i++) {
			if(stations[i] < N) {
				cnt++;
			}
		}
		System.out.println(cnt);
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