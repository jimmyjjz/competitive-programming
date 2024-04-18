import java.util.*;
import java.io.*;
public class ReachfortheTop {
	static class status{
		int pos,jumps;
		public status(int pos, int jumps) {
			this.pos=pos;
			this.jumps=jumps;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int H = readInt(), J = readInt(), N = readInt();
		boolean[] valid = new boolean[H+1];
		for(int i = 0; i<N; i++) {
			int a = readInt(), b = readInt();
			for(int j = a; j<=b; j++)valid[j]=true;
		}
		Queue<status> cur = new LinkedList<status>();
		cur.add(new status(0,0));
		Stack<Integer> nums = new Stack<Integer>();
		for(int i = H; i>0; i--)nums.add(i);
		while(!cur.isEmpty()) {
			status poll = cur.poll();
			if(!valid[poll.pos]) {
				valid[poll.pos]=true;
				cur.add(new status(poll.pos+J,poll.jumps+1));
				if(poll.pos+J>=H) {
					System.out.println(poll.jumps+1);
					return;
				}
				while(nums.peek()<=poll.pos)cur.add(new status(nums.pop(),poll.jumps+1));
			}
		}
		System.out.println("-1");
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