import java.util.*;
import java.io.*;
public class Betting{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static boolean f(long a, long b, long c, long d) {
		double ratea = (double)(b)/(double)(a), rateb = (double)(d)/(double)(c);
		for(int i = 0; i<1000; i++) {
			for(int j = 0; j<1000; j++) {
				if(i+j<((double)(i)*ratea)&&i+j<((double)(j)*rateb)) {
					return true;
				}
			}
		}
		return false;
	}
	public static boolean f2(long a, long b, long c, long d) {
		return(d-c)*(b-a)>c*a;
	}
	public static void main(String[] args) throws IOException{
		int T = readInt();//rearranged
		for(int i = 0; i<T; i++) {
			long a = readLong(), b = readLong(), c = readLong(), d = readLong();
			//System.out.println(f(a,b,c,d)+" "+f2(a,b,c,d));
			System.out.println(f2(a,b,c,d)?"YES":"NO");
			//System.out.println(((double)(b)/(double)(a)-1)*((double)(d)/(double)(c)-1)>1?"YES":"NO");
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