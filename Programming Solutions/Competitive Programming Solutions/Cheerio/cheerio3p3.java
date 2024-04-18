import java.util.*;
import java.io.*;
public class EverythingArray{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		for(int i = 3; i<=M; i++) {
			if(((2*i+1)*(M-i)+i)>=N) {
				int cnt = 0;
				System.out.println(M);
				for(int j = 1; j<=i; j++, cnt++)System.out.print(j+" ");
				int j = 2*i+1;
				for(; j<=N; j+=2*i+1, cnt++)System.out.print(j+" ");
				while(++cnt<=M)System.out.print(Math.min(N,j-(2*i+1)+i)+" ");
				break;
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