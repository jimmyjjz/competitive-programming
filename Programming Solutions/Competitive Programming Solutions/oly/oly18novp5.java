import java.util.*;
import java.io.*;
public class PickitII{
	static class stat{
		long i,v;
		public stat(long i, long v) {
			this.i=i;
			this.v=v;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt();
		long sum = 0;
		Deque<stat> process = new LinkedList<stat>();
		process.add(new stat(0,0));
		for(int i = 0; i<N; i++) {
			if(process.peekFirst().i<i-K)process.pollFirst();
			long in = readInt()+process.peekFirst().v;
			sum+=in-process.peekFirst().v;
			while(!process.isEmpty()&&process.peekLast().v>=in)process.pollLast();
			process.add(new stat(i+1,in));
		}
		if(process.peekFirst().i<N-K)process.pollFirst();
		System.out.println(sum-process.peekFirst().v);
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