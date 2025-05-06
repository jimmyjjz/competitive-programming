import java.util.*;
import java.io.*;
public class perket {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] Sourrgs) throws IOException{
		int N = readInt();
		int[]Sour = new int[N];
		int[]Bitter = new int[N];
		for(int i = 0;i<N;i++){
			Sour[i] = readInt();
			Bitter[i] = readInt();
		}

		int min = Math.abs(Sour[0] - Bitter[0]);

		for(int i = 1;i<(1 << N);i++){
			int multiply = 1, plus = 0;
			for(int j = 0;j<N;j++){
				if(!((i & (1 << j)) != 0)) continue;
				multiply *= Sour[j];
				plus += Bitter[j];
			}
			min = Math.min(min, Math.abs(plus - multiply) );
		}

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