import java.util.*;
import java.io.*;
public class StupendousBowties{
	static class p{
		int x, y;
		p(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		p[] keep = new p[N];
		Map<Integer,List<Integer>> x = new HashMap<Integer,List<Integer>>(), y = new HashMap<Integer,List<Integer>>();
		for(int i = 0; i<N; i++) {
			keep[i]=new p(readInt(),readInt());
			if(x.get(keep[i].x)==null)x.put(keep[i].x, new ArrayList<Integer>());
			x.get(keep[i].x).add(keep[i].y);
			if(y.get(keep[i].y)==null)y.put(keep[i].y, new ArrayList<Integer>());
			y.get(keep[i].y).add(keep[i].x);
		}
		for(int i : x.keySet())Collections.sort(x.get(i));
		for(int i : y.keySet())Collections.sort(y.get(i));
		long total = 0;
		for(p p : keep) {
			long xB = Collections.binarySearch(x.get(p.x),p.y), yB = Collections.binarySearch(y.get(p.y),p.x);
			total+=((long)(x.get(p.x).size()-xB-1)*xB*(long)(y.get(p.y).size()-yB-1)*yB)*2L;
		}
		System.out.println(total);
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