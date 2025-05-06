import java.util.*;
import java.io.*;
public class LightGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt(), M = readInt();
	int[] lights = new int[N];
	for(int i = 0; i<M; i++) {
		lights[readInt()-1]++;
		int in = readInt();
		if(in!=N) {
		lights[in]--;
		}
	}
	//System.out.println(Arrays.toString(lights));
	for(int i = 1; i<N; i++) {
		lights[i]+=lights[i-1];
	}
	int cnt = 0;
	for(int i = 0; i<N; i++) {
		if(lights[i]%2!=0) {
			cnt++;
		}
	}
	System.out.println(cnt);
	//System.out.println(Arrays.toString(lights));
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