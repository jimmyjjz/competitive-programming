import java.util.*;
import java.io.*;
public class GoodNumber{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		String num = readLine();
		long lnum = Long.parseLong(num);
		int K = readInt();
		int len = num.length();
		if(K==0) {
			if(num.charAt(0)=='9') {
				for(int i = 0; i<len; i++)System.out.print(num.charAt(0));
				System.out.println();
			}
			else {
			String a = "", b = "";
			for(int i = 0; i<len; i++)a+=num.charAt(0);
			for(int i = 0; i<len; i++)b+=(int)num.charAt(0)-47;
			if(Long.parseLong(a)>=lnum)System.out.println(a);
			else System.out.println(b);
			}
			return;
		}
		else {
			if(100000000000000000L==lnum) {
				System.out.println("100000000000000000");
				return;
			}
			Set<Long> variations = new HashSet<Long>();
			for(int k = 0; k<10; k++) {
			String s = "";
			for(int i = 0; i<len; i++)s+=k;
			for(int i = 1; i<10; i++)variations.add(Long.parseLong(i+s.substring(1)));
			for(int i = 1; i<len; i++) {
				for(int j = 0; j<10; j++)variations.add(Long.parseLong(s.substring(0,i)+j+s.substring(i+1)));
			}
			}
			for(int k = 0; k<10; k++) {
				String s = "";
				for(int i = 0; i<=len; i++)s+=k;
				for(int i = 1; i<10; i++)variations.add(Long.parseLong(i+s.substring(1)));
				for(int i = 1; i<=len; i++) {
					for(int j = 0; j<10; j++)variations.add(Long.parseLong(s.substring(0,i)+j+s.substring(i+1)));
				}
				}
			long min = Long.MAX_VALUE;
			for(long l : variations)if(l>=lnum)min=Math.min(min,l);
			System.out.println(min);
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