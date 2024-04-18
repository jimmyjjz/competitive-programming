import java.util.*;
import java.io.*;
public class Pyramid{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), arr[] = new int[N];
		for(int i = 0; i<N; i++)arr[i]=readInt();
		int bot = 0, top = N-1, tar = 1;
		while(bot<top) {
			while(bot<top&&arr[bot]!=tar)bot++;
			if(bot>=top)break;
			while(bot<top&&arr[top]!=tar)top--;
			if(bot>=top)break;
			tar++;
		}
		System.out.println(tar-1);
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