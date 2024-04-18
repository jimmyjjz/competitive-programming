import java.util.*;
import java.io.*;
public class PersonalAssistant{
	static class status{
		long l,r,h;
		public status(long l, long r, long h) {
			this.l=l;
			this.r=r;
			this.h=h;
		}
	}
	static class pair{
		long dex,h;
		public pair(long dex, long h) {
			this.dex=dex;
			this.h=h;
		}
	}
	public static class Sortbydex implements Comparator<pair>{
		public int compare(pair a, pair b) {
			return Long.compare(a.dex,b.dex);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		List<status> seg = new ArrayList<status>();
		for(int i = 0; i<N; i++) {
			long l = readLong();
			seg.add(new status(l, l+readLong(), readLong()));
		}
		PriorityQueue<pair> val = new PriorityQueue<pair>(new Sortbydex());
		long v = 0;
		for(status p : seg) {
			while(!val.isEmpty()&&val.peek().dex<=p.l)v=Math.max(v,val.poll().h);
			val.add(new pair(p.r,v+p.h));			
		}
		long max = v;
		for(pair p : val)max=Math.max(max,p.h);
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