import java.util.*;
import java.io.*;
public class Sound{
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
		int N = readInt(), M = readInt(), C = readInt();
		Deque<spot> min = new LinkedList<spot>(), max = new LinkedList<spot>();
		boolean yes = false;
		for(int i = 1; i<=N; i++) {
			if(!min.isEmpty()&&min.peekFirst().i<=i-M)min.pollFirst();
			if(!max.isEmpty()&&max.peekFirst().i<=i-M)max.pollFirst();
			int in = readInt();
			while(!min.isEmpty()&&min.peekLast().v>=in)min.pollLast();
			while(!max.isEmpty()&&max.peekLast().v<=in)max.pollLast();
			min.add(new spot(i,in));
			max.add(new spot(i,in));
			if(i>=M&&max.peekFirst().v-min.peekFirst().v<=C) {
				yes=true;
				System.out.println(i-M+1);
			}
		}
		if(!yes)System.out.println("NONE");
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