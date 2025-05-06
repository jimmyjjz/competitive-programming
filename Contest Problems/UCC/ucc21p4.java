import java.util.*;
import java.io.*;
public class TrampolineJump{
	static class status{
		int moves,dex;
		public status(int moves, int dex) {
			this.moves=moves;
			this.dex=dex;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), street[] = new int[N];
		street[0]=1;
		street[1]=1;
		for(int i = 2; i<N; i++)street[i]=(street[i-1]+street[i-2])%2021;
		for(int i = 0; i<N; i++)street[i]+=((i+1)%50);
		Queue<status> cur = new LinkedList<status>();
		cur.add(new status(0,0));
		boolean[] visited = new boolean[N];
		while(!cur.isEmpty()) {
			status poll = cur.poll();
			if(poll.dex==N-1) {
				System.out.println(poll.moves);
				return;
			}
			try {
			if(!visited[poll.dex]) {
				visited[poll.dex]=true;
				cur.add(new status(poll.moves+1,poll.dex-street[poll.dex]));
				cur.add(new status(poll.moves+1,poll.dex+street[poll.dex]));
				cur.add(new status(poll.moves+1,poll.dex-1));
				cur.add(new status(poll.moves+1,poll.dex+1));
			}
			}catch(Exception e) {};
		}
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