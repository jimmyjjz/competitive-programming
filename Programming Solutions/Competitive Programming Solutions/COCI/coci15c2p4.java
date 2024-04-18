import java.util.*;
import java.io.*;
public class Savez{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int base = 31, mod = 1000000007;
	static long hashaddfront(long hash, char c){return(((hash*base)%mod)+(c-'A'))%mod;}
	static long hashaddback(long hash, char c, long multiply){return(hash+(((c-'A')*multiply)%mod))%mod;}
	public static void main(String[] args) throws IOException{
		Map<String,Integer> best = new HashMap<String,Integer>();
		int N = readInt();
		for(int i = 0; i<N; i++) {
			String s = readLine();
			int len = s.length(), highest = 0;
			long hashf = 0, hashb = 0, pow = 1;
			for(int j = 0; j<len; j++) {
				hashf=hashaddfront(hashf,s.charAt(j));
				hashb=hashaddback(hashb,s.charAt(len-1-j),pow);
				if(hashf==hashb&&best.containsKey(hashf+" "+j))highest=Math.max(best.get(hashf+" "+j),highest);
				pow=(pow*base)%mod;
			}
			best.put(hashf+" "+(len-1),highest+1);
		}
		int max = 0;
		for(int v : best.values())max=Math.max(v,max);
		System.out.println(max);
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