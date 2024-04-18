import java.util.*;
import java.io.*;
public class EnglishorFrench {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = readInt(),s=0,t=0;
		for(int i = 0; i<N; i++) {
			for(char c : readLine().toCharArray()) {
				if(c=='t'||c=='T')t++;
				else if(c=='s'||c=='S')s++;
			}
		}
		if(s>=t)System.out.println("French");
		else System.out.println("English");
	}
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}