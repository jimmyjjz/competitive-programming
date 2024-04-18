import java.util.*;
import java.io.*;
public class PermutationsAndPrime1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		if(N==1) {
			System.out.println("1");
			return;
		}
		if(N<5){
			System.out.println("-1");
			return;
		}
		if(N==5) {
			System.out.println(1+" "+3+" "+5+" "+4+" "+2);
			return;
		}
		System.out.print(1+" "+3+" ");
		for(int i = 7; i<=N; i+=2)System.out.print(i+" ");
		System.out.print(5+" "+4+" "+2+" ");
		for(int i = 6; i<=N; i+=2) {
			if(i+2>N)System.out.println(i);
			else System.out.print(i+" ");
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