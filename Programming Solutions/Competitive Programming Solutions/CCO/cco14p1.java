import java.util.*;
import java.io.*;
public class Troyangles{
	static class pos{
		int x,y,v;
		public pos(int x, int y, int v) {
			this.x=x;
			this.y=y;
			this.v=v;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		char board[][] = new char[N][N];
		int[][] grid = new int[N][N];
		for(int i = 0; i<N; i++) {
			String s = readLine();
			for(int j = 0; j<N; j++) {
				board[i][j]=s.charAt(j);
				if(s.charAt(j)=='.')grid[i][j]=0;
				else grid[i][j]=-1;
			}
		}
		Queue<pos> cur = new LinkedList<pos>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				if(board[i][j]=='#') {
					try{if(board[i-1][j]=='.'||board[i][j-1]=='.'||board[i][j+1]=='.')cur.add(new pos(i,j,0));}
					catch(Exception e) {cur.add(new pos(i,j,0));}
				}
			}
		}
		while(!cur.isEmpty()) {
			pos poll = cur.poll();
			if(grid[poll.x][poll.y]!=-1)continue;
			grid[poll.x][poll.y]=poll.v+1;
			try{if(grid[poll.x+1][poll.y]==-1)cur.add(new pos(poll.x+1,poll.y,poll.v+1));}catch(Exception e) {}
			try{if(grid[poll.x][poll.y-1]==-1)cur.add(new pos(poll.x,poll.y-1,poll.v+1));}catch(Exception e) {}
			try{if(grid[poll.x][poll.y+1]==-1)cur.add(new pos(poll.x,poll.y+1,poll.v+1));}catch(Exception e) {}
		}
//		for(int i = 0; i<N; i++) {
//			for(int j = 0; j<N; j++)System.out.print(grid[i][j]==-1?"*":grid[i][j]);
//			System.out.println();
//		}
		long sum = 0;
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<N; j++)sum+=grid[i][j];
		}
		System.out.println(sum);
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