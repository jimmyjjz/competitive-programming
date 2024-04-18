import java.util.*;
import java.io.*;
public class AClassicProblem{
	static class spot{
		int i,v;
		public spot(int i, int v) {
			this.i=i;
			this.v=v;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), K = readInt(), bot = 0;
		Deque<spot> max = new LinkedList<spot>(), min = new LinkedList<spot>();
		long total = 0;
		for(int i = 1; i<=N; i++) {
			int in = readInt();
			while(!max.isEmpty()&&max.peekLast().v<=in)max.pollLast();
			max.add(new spot(i,in));
			while(!min.isEmpty()&&min.peekLast().v>=in)min.pollLast();
			min.add(new spot(i,in));
			if(max.peekFirst().v-min.peekFirst().v>K) {
				total+=(((long)(i-1-bot)*(long)(i-1-bot))+(long)(i-1-bot))/2L;
				if(min.size()==1)while(max.peekFirst().v-min.peekFirst().v>K)bot=max.pollFirst().i;
				else while(max.peekFirst().v-min.peekFirst().v>K)bot=min.pollFirst().i;
				total-=(((long)(i-1-bot)*(long)(i-1-bot))+(long)(i-1-bot))/2L;
			}
		}
		total+=(((long)(N-bot)*(long)(N-bot))+(long)(N-bot))/2L;
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