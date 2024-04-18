import java.util.*;
import java.io.*;
public class Snakes{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt(), groups[] = new int[N], ranges[][] = new int[N][N];
		for(int i = 0; i<N; i++)groups[i]=readInt();
		for(int i = 0; i<N; i++){
			for(int j = i; j<N; j++) {
				int max = 0, waste = 0;
				for(int k = i; k<=j; k++)max=Math.max(max, groups[k]);
				for(int k = i; k<=j; k++)waste+=max-groups[k];
				ranges[i][j]=waste;
			}
		}
		int[][] place = new int[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)place[i][j]=Integer.MAX_VALUE;
		}
		for(int i = 0; i<N; i++)place[0][i]=ranges[0][i];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(place[j][i]==Integer.MAX_VALUE)break;
				for(int k = i+1; k<N; k++) {
					place[j+1][k]=Math.min(place[j+1][k], place[j][i]+ranges[i+1][k]);
				}
			}
		}
		System.out.println(place[K][N-1]);
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