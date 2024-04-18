import java.util.*;
import java.io.*;
public class BasesMultiplication{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static long basetoten(String num, long base) {
		long out = 0,expo = 1;
		for(int i = num.length()-1; i>=0; i--) {
			out+=expo*Long.parseLong(num.charAt(i)+"");
			expo*=base;
		}
		return out;
	}
	public static long[] tentobase(long base, long num) {
		long[] out = new long[70];
		out[69]=num;
		for(int i = 69; i>=0; i--) {
			if(out[i]>base) {
				out[i-1]=out[i]/base;
				out[i]%=base;
			}
		}
		return out;
	}
	public static void printform(long[] form) {
		boolean flag = false;
		for(long l : form) {
			if(l!=0)flag=true;
			if(flag)System.out.print(l);
		}
		System.out.println(!flag?"0":"");
	}
	public static void main(String[] args) throws IOException{
		for(int i = 0; i<5; i++) {
		long a = basetoten(next(), readLong()), b = basetoten(next(), readLong()), base = readLong();
		long[] forma = tentobase(base, a), formb = tentobase(base, b), result = new long[70];
			for(int j = 69; j>=0; j--) {
				try {
				for(int k = 69; k>=0; k--)result[k-(69-j)]+=forma[j]*formb[k];
				}catch(Exception e) {}
			}
			for(int j = 69; j>=0; j--) {
				if(result[j]>=base) {
					result[j-1]+=result[j]/base;
					result[j]%=base;
				}
			}
			printform(result);
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