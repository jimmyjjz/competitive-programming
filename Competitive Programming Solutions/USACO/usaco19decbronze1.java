import java.util.*;
import java.io.*;
public class CowGymnastics {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int K = readInt(), N = readInt();
		boolean[][] spot = new boolean[N][N];
		for(int i = 0; i<N; i++) {
			spot[i][i] = true;
		}
		for(int i = 0; i<K; i++) {
			int[] temp = new int[N];
			for(int j = 0; j<N; j++) {
				temp[j] = readInt();
			}
			for(int j = 0; j<N; j++) {
				for(int k = j+1; k<N; k++) {
					spot[temp[k]-1][temp[j]-1] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!spot[i][j]) {
					cnt++;
				}
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