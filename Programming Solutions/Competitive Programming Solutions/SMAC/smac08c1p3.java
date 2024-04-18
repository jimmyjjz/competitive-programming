import java.util.*;
import java.io.*;
public class Jumpscotch{
	static class stat{
		int i,v;
		public stat(int i, int v) {
			this.i=i;
			this.v=v;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), D = readInt(), min[] = new int[N];
		if(N==1) {
			System.out.println(readInt());
			return;
		}
		Deque<stat> process = new LinkedList<stat>();
		min[0]=readInt();
		for(int i = 1; i<=Math.min(N-1,D); i++) {
			stat s = new stat(i,readInt()+min[0]);
			while(!process.isEmpty()&&s.v<=process.peekLast().v)process.pollLast();
			process.add(s);
			min[i]=s.v;
		}
		if(D>=N-1) {
			System.out.println(min[N-1]);
			return;
		}
		for(int i = D+1; i<N; i++) {
			if(process.peekFirst().i<i-D)process.pollFirst();
			stat s = new stat(i,readInt()+process.peekFirst().v);
			while(!process.isEmpty()&&s.v<=process.peekLast().v)process.pollLast();
			process.add(s);
			min[i]=s.v;
		}
		System.out.println(min[N-1]);
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