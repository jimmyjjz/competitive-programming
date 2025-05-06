import java.util.*;
import java.io.*;
public class TrickysTreats{
	static class stat{
		int d,t;
		public stat(int d, int t) {
			this.d=d;
			this.t=t;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), T = readInt(), max = 0, cur = 0;
		List<stat> houses = new ArrayList<stat>();
		for(int i = 0; i<N; i++)houses.add(new stat(readInt(),readInt()));
		Collections.sort(houses,(a,b)->Integer.compare(a.d,b.d));
		PriorityQueue<Integer> met = new PriorityQueue<Integer>();
		for(int i = 0; i<N; i++) {
			met.add(houses.get(i).t);
			cur+=houses.get(i).t;
			while(met.size()>Math.max(0,(M-houses.get(i).d*2)/T))cur-=met.poll();
			max=Math.max(max,cur);
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