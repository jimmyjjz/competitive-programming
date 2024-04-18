import java.util.*;
import java.io.*;
public class Matching{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class status{
		int man,visited;
		public status(int man, int visited) {
			this.man=man;
			this.visited=visited;
		}
	}
	public static void main(String[] args) throws IOException{
		int N = readInt(), dp[][] = new int[N][1<<(N+1)];
		boolean been[][] = new boolean[N][1<<(N+1)];
		List<Integer>[] connection = new ArrayList[N];
		for(int i = 0; i<N; i++)connection[i]=new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)if(readInt()==1)connection[i].add(j);
		}
		Queue<status> cur = new LinkedList<status>();
		for(int i : connection[0]) {
			cur.add(new status(0,1<<i));
			dp[0][1<<i]=1;
		}
		while(!cur.isEmpty()) {
			status poll = cur.poll();
			if(poll.man==N-1)continue;
			for(int i : connection[poll.man+1]) {
				if((poll.visited&(1<<i))!=0)continue;
				dp[poll.man+1][poll.visited|(1<<i)]=(dp[poll.man+1][poll.visited|(1<<i)]+dp[poll.man][poll.visited])%1000000007;
				if(been[poll.man+1][poll.visited|(1<<i)])continue;
				been[poll.man+1][poll.visited|(1<<i)]=true;
				cur.add(new status(poll.man+1,poll.visited|(1<<i)));
			}
		}
		int comb = 0;
		for(int i = 0; i<1<<(N+1); i++)comb=(comb+dp[N-1][i])%1000000007;
		System.out.println(comb);
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