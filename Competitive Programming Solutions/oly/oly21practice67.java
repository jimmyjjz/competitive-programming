import java.util.*;
import java.io.*;
public class BobStringPower{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int base = 31, mod = 1000000007;
	static long hashadd(long hash, char c){return(((hash*base)%mod)+(c))%mod;}
	static long hashsub(long hash, char c, long pow){return(((hash-(((c)*pow)%mod))%mod)+mod)%mod;}
	public static int getK(String s) {
		int len = s.length();
		for(int i = 1; i<len; i++) {
		Set<String> all = new HashSet<String>();
		if(len%i==0)for(int j = 0; j<=len-i; j+=i)all.add(s.substring(j,j+i));
		if(all.size()==1)return len/i;
		}
		return 1;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt();
		for(int i = 0; i<N; i++) {
			String s = readLine();
			System.out.println(getK(s));
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