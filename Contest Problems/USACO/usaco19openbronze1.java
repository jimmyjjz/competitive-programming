import java.util.*;
import java.io.*;
public class BucketBrigade {
	static class pos{
		int x,y;
		public pos(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	public static void print2d(boolean[][] arr) {
		for(int i = 0; i<10; i++) {
			System.out.println();
			for(int j = 0; j<10; j++) {
				System.out.print((arr[i][j])?"1 ":"0 ");
			}
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		char[][] board = new char[10][10];
		boolean[][] valid = new boolean[10][10];
		int x = 0, y = 0;
		for(int i = 0; i<10; i++) {
			String s = readLine();
			for(int j = 0; j<10; j++) {
				if(s.charAt(j)=='L') {
					x=i;
					y=j;
				}
				else if(s.charAt(j)=='R') valid[i][j]=true;
				board[i][j]=s.charAt(j);
			}
		}
		Set<pos> convo = new HashSet<pos>();
		convo.add(new pos(x,y));
		int moves = 0;
		while(true) {
			moves++;
			List<pos> current = new ArrayList<pos>(convo);
			convo.clear();
			for(pos p : current) {
				try {
				if(board[p.x][p.y]=='B'){
					System.out.println(moves-2);
					return;
				}
				if(!valid[p.x][p.y]) {
					valid[p.x][p.y]=true;
				convo.add(new pos(p.x+1,p.y));
				convo.add(new pos(p.x-1,p.y));
				convo.add(new pos(p.x,p.y+1));
				convo.add(new pos(p.x,p.y-1));
				}
			}
				catch(Exception e) {}
			}
			
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