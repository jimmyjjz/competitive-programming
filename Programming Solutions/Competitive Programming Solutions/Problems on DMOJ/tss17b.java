import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class ClubFair {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), Q = readInt();
		int[] house = new int[1414216];
		for(int i = 0; i<N; i++) {
			long a = Math.abs(readInt()), b = Math.abs(readInt());
			house[((int)Math.ceil(Math.sqrt((a*a)+(b*b))))]++;
		}
		int save = 0;
		for(int i = 0; i<1414216; i++) {
			if(house[i] != 0) {
				save+=house[i];
			}
			house[i]=save;
		}
		for(int i = 0; i<Q; i++) {
			System.out.println(house[readInt()]);
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