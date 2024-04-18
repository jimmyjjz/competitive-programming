import java.util.*;
import java.io.*;
public class Photoshoot2{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), up = 0, m = 0;
		int[] now = new int[N];
		int[] dex = new int[N];
		for(int i = 0; i<N; i++) {
			int in = readInt()-1;
			now[in]=i;
			dex[i]=in;
		}
		boolean[] ignore = new boolean[N];
		for(int i = 0; i<N; i++) {
			while(ignore[up])up++;
			int n = readInt()-1;
			if(dex[up]!=n) {
				ignore[now[n]]=true;
				m++;
			}
			else up++;
		}
		System.out.println(m);
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