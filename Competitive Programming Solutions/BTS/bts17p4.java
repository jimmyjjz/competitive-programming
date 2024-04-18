import java.util.*;
import java.io.*;
public class WetMud{
	static class dry{
		int i,t;
		public dry(int i, int t) {
			this.i=i;
			this.t=t;
		}
	}
	static class Sortbyt implements Comparator<dry>{
		public int compare(dry a, dry b) {
			return -Integer.compare(a.t,b.t);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), J = readInt(), spot = 0, time = 0;
		if(J>N) {
			System.out.println(0);
			return;
		}
		Stack<dry> drying = new Stack<dry>();
		for(int i = 0; i<M; i++)drying.add(new dry(readInt(),readInt()));
		Collections.sort(drying, new Sortbyt());
		PriorityQueue<Integer> dried = new PriorityQueue<Integer>();
		dried.add(N+1);
		out:{
		while(!drying.isEmpty()) {
			time=drying.peek().t;
			while(!drying.isEmpty()&&drying.peek().t==time)dried.add(drying.pop().i);
			while(dried.peek()<spot)dried.poll();
			while(!dried.isEmpty()&&dried.peek()-spot<=J)spot=dried.poll();
			if(spot==N+1)break out;
		}
		System.out.println("-1");
		return;
		}
		System.out.println(time);
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