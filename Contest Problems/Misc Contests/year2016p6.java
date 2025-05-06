import java.util.*;
import java.io.*;
public class CakeBalancing{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static class status{
		int moves,l,r;
		public status(int moves, int l, int r) {
			this.moves=moves;
			this.l=l;
			this.r=r;
		}
	}
	static Queue<status> cur = new LinkedList<status>();
	static int[][] visited;
	static List<Integer> partl, partr;
	static int sizel,sizer;
	static status poll;
	public static void l(int dex, int num) {
		if(visited[num][poll.r]==-1) {
		visited[num][poll.r]=poll.moves+1;
		cur.add(new status(poll.moves+1,num,poll.r));
		}
		if(dex==sizel)return;
		for(int i = dex; i<sizel; i++)l(i+1,num^(1<<partl.get(i)));
	}
	public static void r(int dex, int num) {
		if(visited[poll.l][num]==-1) {
		visited[poll.l][num]=poll.moves+1;
		cur.add(new status(poll.moves+1,poll.l,num));
		}
		if(dex==sizer)return;
		for(int i = dex; i<sizer; i++)r(i+1,num^(1<<partr.get(i)));
	}
	public static void main(String[] args) throws IOException{
		int L = readInt(), R = readInt(), tolerance = readInt();
		int[] left = new int[L], right = new int[R];
		for(int i = 0; i<L; i++)left[i]=readInt();
		for(int i = 0; i<R; i++)right[i]=readInt();
		visited = new int[1<<L][1<<R];
		int capL = 1<<L, capR = 1<<R;
		for(int i = 0; i<capL; i++) {
			for(int j = 0; j<capR; j++)visited[i][j]=-1;
		}
		cur.add(new status(0,capL-1,capR-1));
		while(!cur.isEmpty()) {
			poll = cur.poll();
			if(visited[0][0]!=-1) {
				System.out.println(visited[0][0]);
				return;
			}
			int lsum = 0, rsum = 0;
			partl = new ArrayList<Integer>();
			partr = new ArrayList<Integer>();
			for(int i = 0; i<L; i++) {
				if((poll.l&(1<<i))!=0) {
					lsum+=left[i];
					partl.add(i);
				}
			}
			for(int i = 0; i<R; i++) {
				if((poll.r&(1<<i))!=0) {
					rsum+=right[i];
					partr.add(i);
				}
			}
			if(Math.abs(lsum-rsum)>tolerance)continue;
			sizel = partl.size();
			sizer = partr.size();
			l(0,poll.l);
			r(0,poll.r);
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