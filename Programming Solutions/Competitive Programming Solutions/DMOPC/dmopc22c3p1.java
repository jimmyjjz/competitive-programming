import java.util.*;
import java.io.*;
public class HolidayColouring{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		long N = readInt(), M = readInt();
		if(N%2==1&&M%2==1)System.out.println(Math.min((N/2)*M+M,(M/2)*N+N)+" "+Math.max((N/2)*M,(M/2)*N));
		else if(M%2==1)System.out.println(N/2*M+" "+N/2*M);
		else System.out.println(M/2*N+" "+M/2*N);
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