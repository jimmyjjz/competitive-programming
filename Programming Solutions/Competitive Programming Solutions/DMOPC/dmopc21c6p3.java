import java.util.*;
import java.io.*;
public class AnArtProblem {
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt(), M = readInt(), K = readInt()+1;
		int[][][] board = new int[N][M][2];
		Queue<pos> cur = new LinkedList<pos>();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				board[i][j][0]=readInt();
				if(board[i][j][0]!=0) {
					board[i][j][1]=K;
					cur.add(new pos(i-1,j));
					cur.add(new pos(i,j-1));
					cur.add(new pos(i,j+1));
					cur.add(new pos(i+1,j));
				}
			}
		}
		while(!cur.isEmpty()&&--K>0){
			int fixed = cur.size();
			while(fixed-->0){
				pos p = cur.poll();
				try {
				if(board[p.x][p.y][0]==0) {
					int min = Integer.MAX_VALUE;
					try {min = Math.min(min,(board[p.x+1][p.y][1]==K||board[p.x+1][p.y][0]==0)?min:board[p.x+1][p.y][0]);}catch(Exception e) {}
					try {min = Math.min(min,(board[p.x-1][p.y][1]==K||board[p.x-1][p.y][0]==0)?min:board[p.x-1][p.y][0]);}catch(Exception e) {}
					try {min = Math.min(min,(board[p.x][p.y+1][1]==K||board[p.x][p.y+1][0]==0)?min:board[p.x][p.y+1][0]);}catch(Exception e) {}
					try {min = Math.min(min,(board[p.x][p.y-1][1]==K||board[p.x][p.y-1][0]==0)?min:board[p.x][p.y-1][0]);}catch(Exception e) {}
					board[p.x][p.y][0]=min;
					board[p.x][p.y][1]=K;
					cur.add(new pos(p.x+1,p.y));
					cur.add(new pos(p.x-1,p.y));
					cur.add(new pos(p.x,p.y+1));
					cur.add(new pos(p.x,p.y-1));
				}
				}catch(Exception e) {}
			}
			
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++)System.out.print(board[i][j][0]+" ");
			System.out.println();
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