import java.util.*;
import java.io.*;
public class PizzaBag{
	static class spot{
		int i;
		long v;
		public spot(int i, long v) {
			this.i=i;
			this.v=v;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt(), slices[] = new int[N*2];
		long presum[] = new long[N*2], max = 0;
		for(int i = 0; i<N; i++) {
			slices[i]=readInt();
			slices[N+i]=slices[i];
		}
		for(int i = 1; i<N*2; i++)presum[i]=presum[i-1]+slices[i];
		Deque<spot> dq = new LinkedList<spot>();
		for(int i = 0; i<N*2; i++) {
			if(!dq.isEmpty()&&dq.peekFirst().i<i-K)dq.pollFirst();
			while(!dq.isEmpty()&&dq.peekLast().v>=presum[i])dq.pollLast();
			dq.add(new spot(i,presum[i]));
			max = Math.max(max, presum[i]-dq.peekFirst().v);
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