import java.util.*;
import java.io.*;
public class ACM{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, presums[][], premins[][][];
	static void fillMin(int a, int b) {
		Arrays.fill(premins[a][b], Integer.MAX_VALUE);
		for(int i = N-2; i>0; i--)premins[a][b][i]=Math.min(premins[a][b][i+1],presums[a][i]+presums[b][N-1]-presums[b][i]);
	}
	static int combMin(int a, int b, int c) {
		int min = Integer.MAX_VALUE;
		for(int i = 1; i<=N-2; i++)min=Math.min(min, presums[a][i-1]+premins[b][c][i]-presums[b][i-1]);
		return min;
	}
	public static void main(String[] args) throws IOException{
		N = readInt();
		presums = new int[3][N];
		premins = new int[3][3][N];
		for(int i = 0; i<3; i++) {
			presums[i][0]=readInt();
			for(int j = 1; j<N; j++)presums[i][j]+=readInt()+presums[i][j-1];
		}
		fillMin(0,1);
		fillMin(1,0);
		fillMin(0,2);
		fillMin(2,0);
		fillMin(1,2);
		fillMin(2,1);
		int min = Integer.MAX_VALUE;
		min=Math.min(min, combMin(0,1,2));
		min=Math.min(min, combMin(0,2,1));
		min=Math.min(min, combMin(1,0,2));
		min=Math.min(min, combMin(1,2,0));
		min=Math.min(min, combMin(2,0,1));
		min=Math.min(min, combMin(2,1,0));
		System.out.println(min);
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