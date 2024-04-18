import java.util.*;
import java.io.*;
public class IntertwinedStrings{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static String a,b;
	static int lena,lenb;
	static Set<String> dupe = new HashSet<String>();
	public static void r(int cnta, int cntb, String cur) {
		if(cnta==lena&&cntb==lenb) {
			dupe.add(cur);
			return;
		}
		if(cnta<lena)r(cnta+1,cntb,cur+a.charAt(cnta));
		if(cntb<lenb)r(cnta,cntb+1,cur+b.charAt(cntb));
	}
	public static void main(String[] args) throws IOException{
		a = next();
		b = next();
		lena = a.length();
		lenb = b.length();
		r(0,0,"");
		for(String s : dupe)System.out.println(s);
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