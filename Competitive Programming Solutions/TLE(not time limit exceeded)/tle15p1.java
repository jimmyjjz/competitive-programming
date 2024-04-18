import java.util.*;
import java.io.*;
class stats{
	String name;
	int time;
	public stats(String name, int time) {
		this.time = time;
		this.name = name;
	}
	 public static String getName(stats a) {
		 return a.name;
	 }
}
class SortTime implements Comparator<stats>{
	public int compare(stats a, stats b) {
		return (int) (a.time - b.time);
	}
}
public class Power {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		Map<String,Integer> profile = new HashMap<String,Integer>();
		List<String> nom = new ArrayList<String>();
		List<stats> result = new ArrayList<stats>();
		int N = readInt(), p = readInt();
		for(int i = 0; i<N; i++) {
			String in = readLine();
			profile.put(in, 0);
			nom.add(in);
		}
		for(int i = 0; i<p; i++) {
			for(int j = 0; j<N; j++) {
				profile.put(nom.get(j),profile.get(nom.get(j))+readInt());
			}
		}
		for(int i = 0; i<N; i++) {
			result.add(new stats(nom.get(i), profile.get(nom.get(i))));
		}
		Collections.sort(result, new SortTime());
		int cnt = 3;
		for(int i = N-1; i>=0; i--) {
			System.out.println(cnt+". "+stats.getName(result.get(i)));
			cnt++;
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