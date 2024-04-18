import java.util.*;
import java.io.*;
public class elevator2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), T = readInt(), M = readInt();
		int cur = 0;
		for(int i = 0; i<M; i++) {
			int time = readInt(), start = readInt(), end = readInt();
			int now = -T;
			boolean on = false;
				out:{
				while(true) {
					now+=T;
					if(time<=now&&start==0) {
						on=true;
					}
					if(on&&end==0) {
						cur+=now-time;
						break;
					}
					for(int j = 1; j<N; j++) {
						now+=T;
						if(time<=now&&start==j) {
							on=true;
						}
						if(on&&end==j) {
							cur+=now-time;
							break out;
						}
					}
					now+=T;
					if(time<=now&&start==N) {
						on=true;
					}
					if(on&&end==N) {
						cur+=now-time;
						break;
					}
					for(int j = N-1; j>0; j--) {
						now+=T;
						if(time<=now&&start==j) {
							on=true;
						}
						if(on&&end==j) {
							cur+=now-time;
							break out;
						}
					}
				}
			}
			//up
		}
		System.out.println(cur);
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