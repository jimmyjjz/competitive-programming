import java.util.*;
import java.io.*;
public class Enraged{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), cnt = 0;
		boolean hallway[][] = new boolean[2][N];
		for(int i = 0; i<2; i++) {
			String s = readLine();
			for(int j = 0; j<N; j++)hallway[i][j]=s.charAt(j)=='S'?true:false;
		}
		for(int i = 0; i<N; i++)if(hallway[0][i]&&hallway[1][i])cnt++;
		if(cnt>2)System.out.println("NO");
		else System.out.println("YES");
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