import java.util.*;
import java.io.*;
public class Deque{
	static class stat{
		long a,b;
		public stat(long a,long b) {
			this.a=a;
			this.b=b;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		long[] nums = new long[N];
		Queue<stat> current = new LinkedList<stat>();
		for(int i = 0; i<N; i++)nums[i]=readLong();
		for(int i = 0; i<N; i++)current.add(new stat(nums[i],0));
		for(int i = 1; i<N; i++){
			stat front = current.poll();
			for(int j = 0; j+i<N; j++) {
				stat now = current.poll();
				if(now.a<front.a)current.add(new stat(now.b+nums[j],now.a));
				else current.add(new stat(front.b+nums[j+i],front.a));
				front=now;
		}
		}
		System.out.println(current.peek().a-current.peek().b);
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