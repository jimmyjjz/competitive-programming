import java.util.*;
import java.io.*;
public class StrategyMeeting{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class pair{
		int a,b;
		public pair(int a, int b) {
			this.a=a;
			this.b=b;
		}
	}
	public static void main(String[] args) throws IOException{
		int T = readInt();
		for(int t = 0; t<T; t++) {
		int N = readInt(), moves[][] = new int[N][1<<(N+1)];
		boolean StateBeen[][] = new boolean[N][1<<(N+1)];
		List<Integer>[] tree = new ArrayList[N];
		for(int i = 0; i<N; i++)tree[i]=new ArrayList<Integer>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)if(readInt()==1)tree[i].add(j);
		}
		moves[0][1]=1;
		Queue<pair> cur = new LinkedList<pair>();
		cur.add(new pair(0,1));
		while(!cur.isEmpty()) {
		pair poll = cur.poll();
		for(int i : tree[poll.a]) {
			if((poll.b&(1<<i))!=0)continue;
			moves[i][poll.b|(1<<i)]=(moves[i][poll.b|(1<<i)]+moves[poll.a][poll.b])%13371337;;
			if(StateBeen[i][poll.b|(1<<i)])continue;
			StateBeen[i][poll.b|(1<<i)]=true;
			cur.add(new pair(i,poll.b|(1<<i)));
		}
		}
		int paths = 0;
		for(int i = 0; i<(1<<(N+1)); i++) {
			//if(moves[N-1][i]!=0)System.out.println(moves[N-1][i]);
			paths=(paths+moves[N-1][i])%13371337;
		}
		System.out.println(paths);
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