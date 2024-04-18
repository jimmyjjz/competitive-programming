import java.util.*;
import java.io.*;
public class MultiplayerMoo{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int region = 0, regionVal[][], board[][], N, owner[][];
	static HashSet<Integer>[] adj;
	static boolean[][] visited;
	static boolean checkerboard() {
		int n = board[0][0];
		for(int i = 0; i<N; i++) {
			for(int j = i%2; j<N; j+=2)if(board[i][j]!=n)return false;
		}
		return true;
	}
	static void r(int x, int y) {
		try {
			if(owner[x][y]!=0)return;
			if(board[x][y]==regionVal[region][1]) {
				regionVal[region][0]++;
				owner[x][y]=region;
				r(x-1,y);r(x,y-1);r(x+1,y);r(x,y+1);
			}
		}
		catch(Exception e) {return;}
	}
	static void r2(int x, int y, int type, int re) {
		try {
			if(board[x][y]==type) {
				if(visited[x][y])return;
				visited[x][y]=true;
				r2(x-1,y,type,re);r2(x,y-1,type,re);r2(x+1,y,type,re);r2(x,y+1,type,re);
			}
			else adj[re].add(owner[x][y]);
		}
		catch(Exception e) {return;}
	}
	public static void main(String[] args) throws IOException{
		N = readInt();
		regionVal = new int[N*N+1][2];
		board = new int[N][N];
		owner = new int[N][N];
		visited = new boolean[N][N];
		int max1 = 0, max2 = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)board[i][j]=readInt();
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(owner[i][j]==0) {
					region++;
					regionVal[region][1]=board[i][j];
					r(i,j);
					max1=Math.max(max1, regionVal[region][0]);
				}
			}
		}
		adj = new HashSet[region+1];
		for(int i = 1; i<=region; i++)adj[i]=new HashSet<Integer>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(!visited[i][j])r2(i,j,board[i][j],owner[i][j]);
			}
		}
		//edge cases
		if(checkerboard()) {
			System.out.println("1\n"+(N*N));
			return;
		}
		if(region==N*N) {
			System.out.println("1\n2");
			return;
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i<=region; i++) {
			for(int x : adj[i]) {
				adj[x].remove(i);
				q.add(i);
				boolean[] valid = new boolean[region+1];
				int total = 0;
				while(!q.isEmpty()) {
					int poll = q.poll();
					if(!valid[poll]&&(regionVal[poll][1]==regionVal[x][1]||regionVal[poll][1]==regionVal[i][1])) {
						valid[poll]=true;
						total+=regionVal[poll][0];
						for(int v : adj[poll])q.add(v);
					}
				}
				max2=Math.max(max2, total);
			}
		}
		System.out.println(max1+"\n"+max2);
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