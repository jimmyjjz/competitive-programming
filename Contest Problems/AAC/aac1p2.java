import java.util.*;
import java.io.*;
public class Racing {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt();
	long D = readLong();//useless
	int K = readInt();
	double X = (100-readDouble())/100.000;
	double[] speeds = new double[N];
	for(int i = 0; i<N; i++) {
		speeds[i] = readDouble();
	}
	double P = readDouble();
	double speed = 0;
	for(int i = 0; i<N; i++) {
		speed = Math.floor(speeds[i]);
		while(speed >= P) {
			speed = Math.floor(speed*X);
			K--;
			if(K < 0) {
				System.out.println("NO");
				return;
			}
		}	
	}
	System.out.println("YES");
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