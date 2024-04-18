import java.util.*;
import java.io.*;
public class Hurontario{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int base = 31, mod = 1000000007;
	static long hashaddfront(long hash, char c){return(((hash*base)%mod)+(c-'A'))%mod;}
	static long hashaddback(long hash, char c, long multiply){return(hash+(((c-'A')*multiply)%mod))%mod;}
	public static void main(String[] args) throws IOException{
		String A = next(), B = next();
		int min = Math.min(A.length(), B.length());
		long hasha = 0, hashb = 0, pow = 1;
		Stack<Integer> spot = new Stack<Integer>();
		for(int i = 0; i<min; i++) {
			hasha=hashaddback(hasha,A.charAt(A.length()-1-i),pow);
			hashb=hashaddfront(hashb,B.charAt(i));
			if(hasha==hashb)spot.push(i);
			pow=(pow*base)%mod;
		}
		while(!spot.isEmpty()&&!A.substring(A.length()-spot.peek()-1).equals(B.substring(0,spot.peek()+1)))spot.pop();
		System.out.println(spot.isEmpty()?A+B:A.substring(0,A.length()-spot.peek()-1)+B);
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