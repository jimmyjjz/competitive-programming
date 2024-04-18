import java.util.*;
import java.io.*;
public class Tide {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> height = new ArrayList<Integer>();
		int N = readInt();
		for(int i = 0; i<N; i++) {
			height.add(readInt());
		}
		Collections.sort(height);
		int mid = (int)Math.ceil(N/2.0)-1;
		for(int i = 0; i<(int)N/2; i++) {
			System.out.print(height.get(mid-i)+" ");
			System.out.print(height.get(mid+1+i)+" ");
		}
		if(N%2!=0) {
			System.out.print(height.get(0));
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