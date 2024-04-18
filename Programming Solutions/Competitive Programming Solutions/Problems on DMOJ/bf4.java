import java.util.*;
import java.io.*;
public class StringFinding{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int base = 31, mod = 1000000007;
	static long pow = 1;
	static void setup(int len){for(int i = 1; i<len; i++)pow=(pow*base)%mod;}
	static long hashadd(long hash, char c){return(((hash*base)%mod)+(c-'a'))%mod;}
	static long hashsub(long hash, char c){return (((hash-(((c-'a')*pow)%mod))%mod)+mod)%mod;}
	public static void main(String[] args) throws IOException{
		String s = readLine(), t = readLine();
		int tlen = t.length(), slen = s.length();
		long thash = 0, shash = 0;
		setup(tlen);
		for(int i = 0; i<tlen; i++) {
			thash=hashadd(thash,t.charAt(i));
			shash=hashadd(shash,s.charAt(i));
		}
		if(thash==shash&&t.equals(s.substring(0,tlen))){
			System.out.println(0);
			return;
		}
		for(int i = tlen; i<slen; i++) {
			shash=hashsub(shash,s.charAt(i-tlen));
			shash=hashadd(shash,s.charAt(i));
			if(thash==shash&&t.equals(s.substring(i-tlen+1,i+1))){
				System.out.println(i-tlen+1);
				return;
			}
		}
		System.out.println(-1);
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