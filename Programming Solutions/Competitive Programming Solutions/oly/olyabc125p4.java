import java.util.*;
import java.io.*;
public class MaxSum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt(), neg = 0;
	long sum = 0;
	List<Integer> absV = new ArrayList<Integer>();
	for(int i = 0; i<N; i++) {
		int in = readInt();
		if(in < 0) {
			neg++;
		}
		sum+=Math.abs(in);
		absV.add(Math.abs(in));
	}
	if(neg%2==0) {
		System.out.println(sum);
	}
	else {
		System.out.println(sum-(Collections.min(absV)*2));
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