import java.util.*;
import java.io.*;
public class ComputerPurchase{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), va = -1, vb = -1;
		String a = "", b = "";
		for(int i = 0; i<N; i++) {
			String s = next();
			int total = 2*readInt()+3*readInt()+readInt();
			if(total>va||(total==va&&a.compareTo(s)>0)) {
				b=a;
				vb=va;
				a=s;
				va=total;
			}
			else if(total>vb||(total==vb&&b.compareTo(s)>0)) {
				b=s;
				vb=total;
			}
		}
		if(N==1)System.out.println(a);
		else if(N!=0)System.out.println(a+"\n"+b);
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