import java.util.*;
import java.io.*;
public class NightmareAThon {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt(), Q = readInt();
	int[] count = new int[10];
	int[][] ratings = new int[N][10];
	for(int i = 0; i<N; i++) {
		ratings[i][readInt()-1]++;
	}
	for(int i = 0; i<10; i++) {
		for(int j = 1; j<N; j++) {
			ratings[j][i]+=ratings[j-1][i];
		}
	}
	for(int i = 0; i<10; i++) {
		count[i]=ratings[N-1][i];
	}
	for(int i = 0; i<Q; i++) {
		int a = readInt()-2, b = readInt()-1;
		int[] clone = count.clone();
		if(a>=0) {
		for(int j = 0; j<10; j++) {
			clone[j]+=ratings[a][j];
		}
		}
		for(int j = 0; j<10; j++) {
			clone[j]-=ratings[b][j];
		}
		for(int j = 9; j>=0; j--) {
			if(clone[j]!=0) {
				System.out.println((j+1)+" "+clone[j]);
				break;
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