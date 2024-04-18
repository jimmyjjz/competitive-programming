import java.util.*;
import java.io.*;
public class GoodGroups {
	public static class pair{
		String a,b;
		public pair(String a, String b) {
			this.a=a;
			this.b=b;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		List<pair> include = new ArrayList<pair>();
		List<pair> exclude = new ArrayList<pair>();
		int N = readInt(), cnt = 0;
		for(int i = 0; i<N; i++)include.add(new pair(next(), next()));
		N = readInt();
		for(int i = 0; i<N; i++)exclude.add(new pair(next(), next()));
		N = readInt();
		Map<String, Integer> group = new HashMap<String, Integer>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<3; j++)group.put(next(),i);
		}
		for(pair p : include)if(!group.get(p.a).equals(group.get(p.b)))cnt++;
		for(pair p : exclude)if(group.get(p.a).equals(group.get(p.b)))cnt++;
		System.out.println(cnt);
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