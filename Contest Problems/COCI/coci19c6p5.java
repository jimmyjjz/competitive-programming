import java.util.*;
import java.io.*;
public class Trener{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int base = 31, mod = 1000000007;
	static long pow = 1;
	static void setup(int len){for(int i = 1; i<len; i++)pow=(pow*base)%mod;}
	static long hashadd(long hash, char c){return(((hash*base)%mod)+(c-'a'+1))%mod;}
	static long hashsub(long hash, char c){return(((hash-(((c-'a'+1)*pow)%mod))%mod)+mod)%mod;}
	public static long toHash(String s) {
		int len = s.length();
		long hash = 0;
		for(int i = 0; i<len; i++)hash=hashadd(hash,s.charAt(i));
		return hash;
	}
	public static Set<Long> toSet(int n, String whole) {
		Set<Long> hashes = new HashSet<Long>();
		int wlen = whole.length();
		pow=1;
		setup(n);
		long hash = 0;
		for(int i = 0; i<n; i++)hash=hashadd(hash,whole.charAt(i));
		hashes.add(hash);
		for(int i = n; i<wlen; i++) {
			hash=hashsub(hash,whole.charAt(i-n));
			hash=hashadd(hash,whole.charAt(i));
			hashes.add(hash);
		}
		return hashes;
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		long values[][] = new long[N][K];
		String[][] s = new String[N][K];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<K; j++)s[i][j]=next();
		}
		Set<Long>[] hashes = new HashSet[K];
		for(int i = 0; i<K; i++)values[0][i]=1;
		for(int i = 0; i<N-1; i++) {
			for(int j = 0; j<K; j++)hashes[j]=toSet(i+1,s[i+1][j]);
			for(int j = 0; j<K; j++) {
				long hash = toHash(s[i][j]);
				for(int k = 0; k<K; k++)if(hashes[k].contains(hash))values[i+1][k]=(values[i+1][k]+values[i][j])%mod;
			}
		}
		long total = 0;
		for(int i = 0; i<K; i++)total=(total+values[N-1][i])%mod;
		System.out.println(total);
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