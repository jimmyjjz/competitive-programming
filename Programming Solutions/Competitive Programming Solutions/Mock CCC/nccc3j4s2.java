import java.util.*;
import java.io.*;
public class median {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> First = new ArrayList<Integer>();
		List<Integer> Second = new ArrayList<Integer>();
		int N = readInt(), point = (int) Math.ceil(N/2.0)-1;
		for(int j = 0; j<N; j++) {
		for(int i = 0; i<N; i++) {
			First.add(readInt());
		}
		Collections.sort(First);
		if(N%2==0) {
			Second.add((int)Math.ceil((First.remove(point)+First.remove(point))/2.0));
		}
		else {
			Second.add(First.remove(point));
		}
		First.clear();
		}
		Collections.sort(Second);
		if(N%2==0) {
		System.out.println((int)Math.ceil((Second.remove(point)+Second.remove(point))/2.0));
		}
		else {
		System.out.println(Second.remove(point));
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