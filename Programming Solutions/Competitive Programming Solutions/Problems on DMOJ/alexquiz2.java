import java.util.*;
import java.io.*;
public class SumOfPrimes2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int size = 100001;
		int Q = readInt();
		int[] sieve = new int[size];
		for(int i = 0; i<size; i++) {
			sieve[i]=i;
		}
		for(int i = 2; i<size; i++) {
			boolean comp = false;
			for(int j = 2; j<=(int)Math.sqrt(i); j++) {
				if(i%j==0) {
					comp = true;
					break;
				}
			}
			if(comp) {
				sieve[i]=0;
			}
		}
		sieve[1] = 0;
		for(int i = 1; i<size; i++) {
			sieve[i]+=sieve[i-1];
		}
		for(int i = 0; i<Q; i++) {
			int a = readInt(), b = readInt();
			System.out.println(sieve[b]-sieve[a-1]);
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