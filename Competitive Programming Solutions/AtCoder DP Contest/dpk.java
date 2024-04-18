import java.util.*;
import java.io.*;
public class Stones{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		int[] moves = new int[N];
		for(int i = 0; i<N; i++)moves[i]=readInt();
		boolean[] fwin = new boolean[K+moves[N-1]+1];
		for(int i = 0; i<=K; i++) {
			if(!fwin[i]){
				for(int j : moves)fwin[i+j]=true;
			}
		}
		System.out.println(fwin[K]?"First":"Second");
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