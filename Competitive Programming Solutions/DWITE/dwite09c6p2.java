import java.util.*;
import java.io.*;
public class Roundtopoweroftwo{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> powers = new ArrayList<Integer>();
		for(int i = 1; i<=65536; i*=2)powers.add(i);
		for(int i = 0; i<5; i++) {
			int n = readInt(), min = Integer.MAX_VALUE, value = 0;
			for(int j : powers) {
				if(Math.abs(n-j)<=min) {
					min=Math.abs(n-j);
					value = j;
				}
			}
			System.out.println(value);
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