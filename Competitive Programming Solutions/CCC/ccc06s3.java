import java.util.*;
import java.io.*;
public class TinCanTelephone {
	static class point{
		int x,y;
		public point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static class line{
		point a,b;
		public line(point a, point b) {
			this.a=a;
			this.b=b;
		}
	}
	public static double dis(point a, point b) {
		return Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
	}
	public static boolean intersection(line a, line b) {
		return  ((b.b.y-a.a.y)*(b.a.x-a.a.x)>(b.a.y-a.a.y)*(b.b.x-a.a.x))
				!=
				((b.b.y-a.b.y)*(b.a.x-a.b.x)>(b.a.y-a.b.y)*(b.b.x-a.b.x))
				&&
				((b.a.y-a.a.y)*(a.b.x-a.a.x)>(a.b.y-a.a.y)*(b.a.x-a.a.x))
				!=
				((b.b.y-a.a.y)*(a.b.x-a.a.x)>(a.b.y-a.a.y)*(b.b.x-a.a.x))
				||
				dis(a.a,b.a) + dis(b.a,a.b) == dis(a.a,a.b)
				||
				dis(a.a,b.b) + dis(b.b,a.b) == dis(a.a,a.b);
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		line compare = new line(new point(readInt(), readInt()),new point(readInt(), readInt()));
		List<List<line>> groups = new ArrayList<List<line>>();
		int N = readInt(), cnt = 0;
		for(int i = 0; i<N; i++) {
			int M = readInt();
			List<line> slot = new ArrayList<line>();
			point pre = new point(readInt(), readInt());
			point first = pre;
			for(int j = 1; j<M; j++) {
				point p = new point(readInt(), readInt());
				slot.add(new line(pre,p));
				pre=p;
			}
			slot.add(new line(pre,first));
			groups.add(slot);
		}
		int size = groups.size();
		for(int i = 0; i<size; i++) {
			List<line> cur = new ArrayList<line>(groups.get(i));
			int cursize = cur.size();
			for(int j = 0; j<cursize; j++) {
				if(intersection(compare,cur.get(j))) {
					cnt++;
					break;
				}
			}
		}
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