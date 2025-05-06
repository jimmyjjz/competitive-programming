import java.util.*;
import java.io.*;
public class DaisyChains {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] flowers = new int[N];
		int cnt = 0;
		for(int i = 0; i<N; i++) {
			flowers[i]= readInt();
		}
		for(int i = 0; i<N; i++) {
			for(int j = i; j<N; j++) {
				int sum = 0;
				for(int k = i; k<=j; k++) {
					sum+=flowers[k];
				}
				double deci = sum/((double)j-(double)i+1.00);
				for(int k = i; k<=j; k++) {
					if(deci%1==0 && flowers[k] == (int)deci) {
						//System.out.println(i+" "+j);
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
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