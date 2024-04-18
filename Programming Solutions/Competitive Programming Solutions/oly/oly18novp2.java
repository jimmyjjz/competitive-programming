import java.util.*;
import java.io.*;
public class RogersHomework{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long best = 0;
		List<Integer>[] deadline = new ArrayList[N+1];
		for(int i = 1; i<=N; i++)deadline[i]=new ArrayList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->-Integer.compare(a,b));
		for(int i = 0; i<N; i++) {
			int in = readInt();
			if(in>N)pq.add(readInt());
			else deadline[in].add(readInt());
		}
		for(int i = N; i>0; i--) {
			for(int j : deadline[i])pq.add(j);
			if(!pq.isEmpty())best+=pq.poll();
		}
		System.out.println(best);
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