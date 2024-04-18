import java.util.*;
import java.io.*;
public class MaximumDistance {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int T = readInt();
	for(int i = 0; i<T; i++) {
		int N = readInt();
		int[] a = new int[N];
		int[] b = new int[N];
		Map<Integer, Integer> spotA = new HashMap<Integer, Integer>();
		Map<Integer, Integer> spotB = new HashMap<Integer, Integer>();
		for(int j = 0; j<N; j++) {
			a[j]=readInt();
		}
		for(int j = 0; j<N; j++) {
			b[j]=readInt();
		}
		for(int j = 0; j<N; j++) {
			if(spotA.get(a[j])==null)spotA.put(a[j], j);
		}
		for(int j = N-1; j>=0; j--) {
			if(spotB.get(b[j])==null)spotB.put(b[j], j);
		}
		List<Integer> keys = new ArrayList<Integer>(spotA.keySet());
		int max = 0;
		for(int n : keys) {
			if(spotB.get(n)!=null)max = Math.max(Math.max(spotA.get(n),spotB.get(n))-Math.min(spotA.get(n),spotB.get(n)),max);
		}
		System.out.println("The maximum distance is "+max);
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