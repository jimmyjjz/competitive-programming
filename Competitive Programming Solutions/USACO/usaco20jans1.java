import java.util.*;
import java.io.*;
public class BerryPicking {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
	int N = readInt(), K = readInt();
	List<Integer> berries = new ArrayList<Integer>();
	for(int i = 0; i<N; i++) {
		berries.add(readInt());
	}
	int max = Collections.max(berries);
	int i = 1;
	List<Integer> store = new ArrayList<Integer>();
	int get = 0;
	for(; i<=max; i++) {
		int cnt = 0;
		for(int n : berries) {
				int temp = n;
				while((temp/i)>0) {
				cnt++;
				store.add(i);
				temp-=i;
				}
				store.add(temp);
		}
		if(K/2 > cnt)break;
		Collections.sort(store);
		Collections.reverse(store);
		//System.out.println(store);
		int now = 0;
		try {
		for(int j = K/2; j<K; j++) {
			now+=store.get(j);
		}
		}
		catch(Exception e) {}
		get = Math.max(now, get);
		store = new ArrayList<Integer>();
	}
	System.out.println(get);
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