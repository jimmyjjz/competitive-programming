import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class ArithmeticOrGeometric{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int T = readInt();
		BigInteger mod = new BigInteger(1000000007+"");
		for(int i = 0; i<T; i++) {
			int a = readInt(), b = readInt(), c = readInt();
			if(c-b == b-a) {
				//System.out.println(((long)(a+(readInt()-1)*(c-b))));//mod this
				System.out.println(((long)(a+(readLong()-1)*(c-b)))%(1000000007));
			}
			else if(c/b == b/a) {
				BigInteger multi = new BigInteger(a+"");
				BigInteger save = new BigInteger(c/b+"");
				BigInteger in = new BigInteger((readInt()-1)+"");
				save=save.modPow(in, mod);
				save=save.multiply(multi);
				save=save.mod(mod);
				System.out.println(save.toString());
				//System.out.println(((long)(a*Math.pow(c/b, readLong()-1))));
				//System.out.println(((long)(a*Math.pow(c/b, readLong()-1)))%(1000000000+7));
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