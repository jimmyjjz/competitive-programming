import java.util.*;
import java.io.*;
public class ObligatoryTriangleProblem{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static double mtod(double x, double y) {
		return Math.toDegrees(Math.atan2(y,x))>0?Math.toDegrees(Math.atan2(y,x)):360+Math.toDegrees(Math.atan2(y,x));
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), A = readInt();
		int num = 0;
		double min = Integer.MAX_VALUE;
		for(int i = 1; i<=N; i++) {
			double deg = mtod(readInt(), readInt());
			if(min>Math.min(360-Math.abs(A-deg), Math.abs(A-deg))) {
				min=Math.min(360-Math.abs(A-deg), Math.abs(A-deg));
				num=i;
			}
		}
		System.out.println(num);
		//System.out.println(mtod(1,0));
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