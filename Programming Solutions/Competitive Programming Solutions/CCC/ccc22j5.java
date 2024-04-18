import java.util.*;
import java.io.*;
public class SquarePool{
	static class point{
		int x,y;
		public point(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static class SortByX implements Comparator<point>{
		public int compare(point a, point b) {
			return Integer.compare(a.x,b.x);
		}
	}
	static class SortByY implements Comparator<point>{
		public int compare(point a, point b) {
			return Integer.compare(a.y,b.y);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), T = readInt(), max = 1;
		List<point> p = new ArrayList<point>();
		for(int i = 0; i<T; i++)p.add(new point(readInt(), readInt()));
		p.add(new point(0, 0));
		p.add(new point(N+1, 0));
		p.add(new point(0, N+1));
		p.add(new point(N+1, N+1));
		Collections.sort(p, new SortByX());
		for(int i = 0; i<T+4; i++) {
			for(int j = i+1; j<T+4; j++) {
				List<point> sector = new ArrayList<point>();
				for(int k = i+1; k<j; k++)sector.add(p.get(k));
				sector.add(new point(0,0));
				sector.add(new point(0,N+1));
				Collections.sort(sector, new SortByY());
				for(int k = 0; k<j-i; k++)max = Math.max(max, Math.min(p.get(j).x-p.get(i).x-1, Math.max(sector.get(k).y, sector.get(k+1).y)-Math.min(sector.get(k).y, sector.get(k+1).y)-1));
			}
		}
		System.out.println(max);
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