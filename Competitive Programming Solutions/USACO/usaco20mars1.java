import java.util.*;
import java.io.*;
public class SocialDistancing {
	static class inv{
		long x,y;
		public inv(long x, long y) {
			this.x=x;
			this.y=y;
		}
	}
	static class SortbyX implements Comparator<inv>{
		public int compare(inv a, inv b) {
			return Long.compare(a.x,b.x);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt();
		List<inv> grass = new ArrayList<inv>();
		for(int i = 0; i<M; i++) grass.add(new inv(readLong(), readLong()));
		Collections.sort(grass, new SortbyX());
		long bot = 1, top = (long) Math.pow(10,18);
		while(bot+1<top) {
			boolean yes = true;
			long now = grass.get(0).x;
			int cnt = 0;
			for(int i = 1; i<N; i++) {
				now+=(bot+top)/2;
				while(cnt<M&&now>grass.get(cnt).y) {
					cnt++;
				}
				if(cnt==M) {
					yes = false;
					break;
				}
				if(grass.get(cnt).x>now) {
					now=grass.get(cnt).x;
				}
			}
			if(yes) {
				bot = (bot+top)/2;
			}
			else{
				top = (bot+top)/2;
			}
		}
		System.out.println(bot);
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