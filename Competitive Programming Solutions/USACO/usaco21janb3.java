import java.util.*;
import java.io.*;
public class stall {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<Integer> cows = new ArrayList<Integer>();
		List<Integer> stalls = new ArrayList<Integer>();
		List<Integer> points = new ArrayList<Integer>();
		int N = readInt();
		for(int i = 0; i<N; i++) {
			cows.add(readInt());
		}
		for(int i = 0; i<N; i++) {
			stalls.add(readInt());
		}
		for(int i = 0; i<N; i++) {
			int sum = 0;
			for(int j = 0; j<N; j++) {
				if(cows.get(j) <= stalls.get(i)) {
					sum++;
				}
			}
			points.add(sum);
		}
		Collections.sort(points);
		long result = 1;
		for(int i = 0; i<N; i++) {
			result*=points.get(i)-i;
		}
		System.out.println(result);
		
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