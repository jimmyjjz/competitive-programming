import java.util.*;
import java.io.*;
public class BigMatressTournament {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		//2b, 2a, 1c 1a, 2a 1b, 1a 1b 1c
		for(int i = 0; i<N; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			if(c<=a) {
				a-=c;
				b%=2;
				if(b==1&&a!=0&&a%2==0) {
					System.out.println("YES");
					continue;
				}
				if(b==0&&a%2==0) {
					System.out.println("YES");
					continue;
				}
				if(b==1&&c>0&&a%2==0) {
					System.out.println("YES");
					continue;
				}
			}
			System.out.println("NO");
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