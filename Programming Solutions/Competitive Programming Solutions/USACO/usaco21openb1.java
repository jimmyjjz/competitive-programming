import java.util.*;
import java.io.*;
public class Acowdemia1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt(), L = readInt();
	int[] papers = new int[N];
	for(int i = 0; i<N; i++) {
		papers[i] = readInt();
	}
	Arrays.sort(papers);
	//System.out.println(Arrays.toString(papers));
	for(int i = 1; i<=N; i++) {
		for(int j = N-i; j<N; j++) {
			if(papers[j] >= i) {
				break;
			}
			if(L == 0 || papers[j]+1 != i) {
				System.out.println(i-1);
				//System.out.println(Arrays.toString(papers));
				System.exit(0);
			}
				L--;
				papers[j]++;
		}
	}
	System.out.println(N);
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